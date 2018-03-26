package org.hyl.service.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hyl.base.auditing.service.dto.IdDTO;
import org.hyl.domain.Authority;
import org.hyl.domain.MyUser;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO extends IdDTO {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 6, max = 32, message = "用户名的长度只能在6至32个字符之间")
    private String username;

    private Set<String> roles;

    public static UserDTO adapt(MyUser user) {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        dto.setRoles(user.getAuthorities().stream().map(Authority::getDescribe).collect(Collectors.toSet()));
        return dto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
