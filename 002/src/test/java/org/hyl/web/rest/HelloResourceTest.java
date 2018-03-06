package org.hyl.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hyl.domain.Hello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "user", password = "123456")
public class HelloResourceTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void create() throws Exception {
        Hello hello = new Hello();
        hello.setNode("牛逼啊");
        console(MockMvcRequestBuilders.post("/api/hello").contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(hello)));
    }

    @Test
    public void delete() throws Exception {
        console(MockMvcRequestBuilders.delete("/api/hello/{id}", "402881ea61fb56180161fb56270b0000"));
    }

    @Test
    public void getAll() throws Exception {
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("page", "0");
        map.add("size", "10");
        console(MockMvcRequestBuilders.get("/api/hello").params(map));
    }

    @Test
    public void getById() throws Exception {
        console(MockMvcRequestBuilders.get("/api/hello/{id}", "402881ea61fb56180161fb56270b0000"));
    }

    @Test
    public void update() throws Exception {
        Hello hello = new Hello();
        hello.setId("402881ea61fb56180161fb56270b0000");
        hello.setNode("牛逼啊！");
        console(MockMvcRequestBuilders.put("/api/hello").contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(hello)));
    }

    private void console(RequestBuilder builder) throws Exception {
        logger.info(mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString());
    }
}