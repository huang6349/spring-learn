package org.hyl.service.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hyl.domain.Authority;
import org.hyl.domain.MyUser;

import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String username;

    private Set<String> roles;

    public UserDTO() {
    }

    public UserDTO(MyUser user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getAuthorities().stream().map(Authority::getDescribe).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
