package org.hyl.service.dto;

import com.google.common.collect.Lists;

import java.util.List;

public class LevelDTO {

    private String level;

    private List<LevelDTO> dicts = Lists.newArrayList();

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<LevelDTO> getDicts() {
        return dicts;
    }

    public void setDicts(List<LevelDTO> dicts) {
        this.dicts = dicts;
    }
}
