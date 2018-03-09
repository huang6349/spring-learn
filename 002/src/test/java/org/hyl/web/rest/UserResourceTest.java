package org.hyl.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hyl.domain.MyUser;
import org.hyl.repository.UserRepository;
import org.hyl.security.AuthoritiesConstants;
import org.hyl.web.rest.vm.ManagedUserVM;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "123456")
public class UserResourceTest {

    private static final String URI = "/api/users";
    private static final String DEFAULT_USERNAME = "huang6349";
    private static final String DEFAULT_PASSWORD = "123456";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {

    }

    @Test
    @Transactional
    public void create() throws Exception {
        String url = URI;
        int size = userRepository.findAll().size();
        ManagedUserVM managedUserVM = new ManagedUserVM();
        managedUserVM.setUsername(DEFAULT_USERNAME);
        managedUserVM.setPassword(DEFAULT_PASSWORD);
        managedUserVM.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));
        RequestBuilder builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(managedUserVM));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<MyUser> users = userRepository.findAll();
        assertThat(users).hasSize(size + 1);
        MyUser user = users.get(users.size() - 1);
        assertThat(user.getUsername()).isEqualTo(DEFAULT_USERNAME);
    }
}