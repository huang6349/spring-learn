package org.hyl.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hyl.domain.Hello;
import org.hyl.repository.HelloRepository;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "user", password = "123456")
public class HelloResourceTest {

    private static final String URI = "/api/hello";
    private static final String DEFAULT_NODE = "AAAAAAAAAA";
    private static final String UPDATED_NODE = "BBBBBBBBBB";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloRepository helloRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Hello hello;

    @Before
    public void setup() {
        hello = new Hello();
        hello.setNode(DEFAULT_NODE);
    }

    @Test
    @Transactional
    public void create() throws Exception {
        String url = URI;
        int size = helloRepository.findAll().size();
        RequestBuilder builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(hello));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Hello> hellos = helloRepository.findAll();
        assertThat(hellos).hasSize(size + 1);
        Hello test = hellos.get(hellos.size() - 1);
        assertThat(test.getNode()).isEqualTo(DEFAULT_NODE);
    }

    @Test
    @Transactional
    public void getAll() throws Exception {
        String url = URI + "?sort=id,desc";
        RequestBuilder builder = MockMvcRequestBuilders.get(url);
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void getById() throws Exception {
        String url = URI + "/{id}";
        helloRepository.saveAndFlush(hello);
        RequestBuilder builder = MockMvcRequestBuilders.get(url, hello.getId());
        mockMvc.perform(builder).andExpect(status().isOk());
    }

    @Test
    @Transactional
    public void update() throws Exception {
        String url = URI;
        helloRepository.saveAndFlush(hello);
        int size = helloRepository.findAll().size();
        Hello update = helloRepository.findOne(hello.getId());
        update.setNode(UPDATED_NODE);
        RequestBuilder builder = MockMvcRequestBuilders.put(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(update));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Hello> hellos = helloRepository.findAll();
        assertThat(hellos).hasSize(size);
        Hello test = hellos.get(hellos.size() - 1);
        assertThat(test.getNode()).isEqualTo(UPDATED_NODE);
    }

    @Test
    @Transactional
    public void delete() throws Exception {
        String url = URI + "/{id}";
        helloRepository.saveAndFlush(hello);
        int size = helloRepository.findAll().size();
        RequestBuilder builder = MockMvcRequestBuilders.delete(url, hello.getId());
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Hello> hellos = helloRepository.findAll();
        assertThat(hellos).hasSize(size - 1);
    }
}