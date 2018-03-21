package org.hyl.service.dto;

import javax.validation.constraints.NotNull;

public class PermissionsDTO extends IdDTO {

    private Long pid = 0L;

    @NotNull(message = "权限名称不能为空")
    private String name;

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
}
