package org.hyl.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hyl.utils.LevelUtil;
import org.hyl.domain.Dict;
import org.hyl.repository.DictRepository;
import org.hyl.service.dto.DictDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
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
import java.util.Optional;

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

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DictRepository dictRepository;

    private DictDTO dto;

    @Before
    public void setup() {
        dto = new DictDTO();
        dto.setIdent(DEFAULT_IDENT);
        dto.setData(DEFAULT_DATA);
        dto.setCode(DEFAULT_CODE);
        dto.setDescribe(DEFAULT_DESCRIBE);
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", password = "123456")
    public void create() throws Exception {
        String url = URI1;
        int size = dictRepository.findAll().size();
        RequestBuilder builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(dto));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Dict> dicts = dictRepository.findAll();
        assertThat(dicts).hasSize(size + 1);
        Dict test = dicts.get(dicts.size() - 1);
        assertThat(test.getLevel()).isEqualTo(LevelUtil.calculateLevel(getLevel(dto.getPid()), dto.getPid()));
        assertThat(test.getIdent()).isEqualTo(DEFAULT_IDENT);
        assertThat(test.getData()).isEqualTo(DEFAULT_DATA);
        assertThat(test.getCode()).isEqualTo(DEFAULT_CODE);
        assertThat(test.getDescribe()).isEqualTo(DEFAULT_DESCRIBE);
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", password = "123456")
    public void createWithExistingId() throws Exception {
        String url = URI1;
        Dict dict = new Dict();
        BeanUtils.copyProperties(dto, dict);
        dict.setId(1L);
        int size = dictRepository.findAll().size();
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
        Dict dict = new Dict();
        BeanUtils.copyProperties(dto, dict);
        dict.setLevel(LevelUtil.calculateLevel(getLevel(dict.getPid()), dict.getPid()));
        dictRepository.saveAndFlush(dict);
        int size = dictRepository.findAll().size();
        RequestBuilder builder = MockMvcRequestBuilders.post(url).contentType(MediaType.APPLICATION_JSON_UTF8).content(objectMapper.writeValueAsString(dto));
        mockMvc.perform(builder).andExpect(status().isOk());
        List<Dict> dicts = dictRepository.findAll();
        assertThat(dicts).hasSize(size);
    }

    private String getLevel(Long id) {
        if (id == null) return null;
        return Optional.of(id).map(dictRepository::findOne).map(Dict::getLevel).orElse(null);
    }
}