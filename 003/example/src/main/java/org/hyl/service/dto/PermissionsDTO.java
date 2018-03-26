package org.hyl.service.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hyl.base.auditing.service.dto.IdDTO;

public class PermissionsDTO extends IdDTO {

    private Long pid = 0L;

    @NotBlank(message = "权限名称不能为空")
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
