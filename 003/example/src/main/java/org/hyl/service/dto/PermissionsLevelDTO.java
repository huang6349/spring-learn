package org.hyl.service.dto;

import org.hyl.domain.Permissions;
import org.springframework.beans.BeanUtils;

public class PermissionsLevelDTO extends LevelDTO<PermissionsLevelDTO> {

    private String name;

    public static PermissionsLevelDTO adapt(Permissions permissions) {
        PermissionsLevelDTO dto = new PermissionsLevelDTO();
        BeanUtils.copyProperties(permissions, dto);
        return dto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
