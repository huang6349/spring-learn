package org.hyl.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hyl.domain.Dict;
import org.hyl.repository.DictRepository;
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
public class DictResourceTest {

    private static final String URI1 = "/admin/dict";

    private static final String DEFAULT_IDENT = "DEFAULT_IDENT";
    private static final String DEFAULT_DATA = "DEFAULT_DATA";
    private static final String DEFAULT_CODE = "DEFAULT_CODE";
    private static final String DEFAULT_DESCRIBE = "DEFAULT_DESCRIBE";
    private static final Integer DEFAULT_SEQ = 0;
    private static final Long DEFAULT_PID = 0L;
    private static final Byte DEFAULT_STATE = 0;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DictRepository dictRepository;

    private Dict dict;

    @Before
    public void setup() {
        dict = new Dict();
        dict.setIdent(DEFAULT_IDENT);
        dict.setData(DEFAULT_DATA);
        dict.setCode(DEFAULT_CODE);
        dict.setDescribe(DEFAULT_DESCRIBE);
        dict.setSeq(DEFAULT_SEQ);
        dict.setPid(DEFAULT_PID);
        dict.setState(DEFAULT_STATE);
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", password = "123456")
    public void create() throws Exception {
        String url = URI1;
        int size = dictRepository.findAll().size();
        RequestBuilder builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(dict));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Dict> dicts = dictRepository.findAll();
        assertThat(dicts).hasSize(size + 1);
        Dict test = dicts.get(dicts.size() - 1);
        assertThat(test.getIdent()).isEqualTo(DEFAULT_IDENT);
        assertThat(test.getData()).isEqualTo(DEFAULT_DATA);
        assertThat(test.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(test.getDescribe()).isEqualTo(DEFAULT_DESCRIBE);
        assertThat(test.getSeq()).isEqualTo(DEFAULT_SEQ);
        assertThat(test.getPid()).isEqualTo(DEFAULT_PID);
        assertThat(test.getState()).isEqualTo(DEFAULT_STATE);
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", password = "123456")
    public void createWithExistingId() throws Exception {
        String url = URI1;
        int size = dictRepository.findAll().size();
        dict.setId(1L);
        RequestBuilder builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(dict));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Dict> dicts = dictRepository.findAll();
        assertThat(dicts).hasSize(size);
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", password = "123456")
    public void createWithExistingIdent() throws Exception {
        String url = URI1;
        dictRepository.saveAndFlush(dict);
        int size = dictRepository.findAll().size();
        Dict exist = new Dict();
        exist.setIdent(dict.getIdent());
        exist.setData(dict.getData());
        exist.setCode(dict.getCode());
        exist.setDescribe(dict.getDescribe());
        exist.setSeq(dict.getSeq());
        exist.setPid(dict.getPid());
        exist.setState(dict.getState());
        RequestBuilder builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(exist));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Dict> dicts = dictRepository.findAll();
        assertThat(dicts).hasSize(size);
    }
}