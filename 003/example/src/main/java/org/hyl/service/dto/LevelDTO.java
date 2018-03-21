package org.hyl.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import java.util.List;

public class LevelDTO<E> extends IdDTO {

    private Long pid;

    @JsonIgnore
    private String level;

    @JsonIgnore
    private Integer seq = 0;

    private List<E> child = Lists.newArrayList();

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public List<E> getChild() {
        return child;
    }

    public void setChild(List<E> child) {
        this.child = child;
    }
}
