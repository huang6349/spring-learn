package org.hyl.service.dto;

import org.hyl.domain.Permissions;

import javax.validation.constraints.NotNull;

public class PermissionsDTO {

    private Long id;

    private Long pid = 0L;

    @NotNull(message = "权限名称不能为空")
    private String name;

    private Integer seq = 0;

    public PermissionsDTO() {
    }

    public PermissionsDTO(Permissions permissions) {
        this.id = permissions.getId();
        this.pid = permissions.getPid();
        this.name = permissions.getName();
        this.seq = permissions.getSeq();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
