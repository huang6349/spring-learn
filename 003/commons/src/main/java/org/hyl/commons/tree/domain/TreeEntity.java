package org.hyl.commons.tree.domain;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class TreeEntity<E, ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = -2453958468302241391L;

    private ID id;

    private ID pid;

    private Integer seq;

    private List<E> child = Lists.newArrayList();

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public ID getPid() {
        return pid;
    }

    public void setPid(ID pid) {
        this.pid = pid;
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
