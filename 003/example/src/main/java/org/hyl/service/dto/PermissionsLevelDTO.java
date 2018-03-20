package org.hyl.service.dto;

import com.google.common.collect.Lists;
import org.hyl.domain.Permissions;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class PermissionsLevelDTO extends PermissionsDTO {

    private String level;

    private List<PermissionsLevelDTO> child = Lists.newArrayList();

    public static PermissionsLevelDTO adapt(Permissions permissions) {
        PermissionsLevelDTO dto = new PermissionsLevelDTO();
        BeanUtils.copyProperties(permissions, dto);
        return dto;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<PermissionsLevelDTO> getChild() {
        return child;
    }

    public void setChild(List<PermissionsLevelDTO> child) {
        this.child = child;
    }
}
