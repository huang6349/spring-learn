package org.hyl.service.dto;

import org.hyl.domain.Dict;

import javax.validation.constraints.NotNull;

public class DictDTO {

    private Long id;

    private Long pid = 0L;

    @NotNull(message = "字典标识不能为空")
    private String ident;

    @NotNull(message = "字典数据不能为空")
    private String data;

    private String code;

    private String describe;

    private Integer seq = 0;

    private Byte state = 0;

    public DictDTO() {
    }

    public DictDTO(Dict dict) {
        this.id = dict.getId();
        this.pid = dict.getPid();
        this.ident = dict.getIdent();
        this.data = dict.getData();
        this.code = dict.getCode();
        this.describe = dict.getDescribe();
        this.seq = dict.getSeq();
        this.state = dict.getState();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
