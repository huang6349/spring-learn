package org.hyl.service.dto;

import com.google.common.collect.Lists;

import java.util.List;

public class LevelDTO {

    private Long id;

    private String level;

    private Integer seq;

    private List<LevelDTO> child = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public List<LevelDTO> getChild() {
        return child;
    }

    public void setChild(List<LevelDTO> child) {
        this.child = child;
    }
}
