package org.hyl.service.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hyl.config.Constants;
import org.hyl.domain.Authority;
import org.hyl.domain.MyUser;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;

    @NotBlank
    @Pattern(regexp = Constants.USER_NAME_REGEX)
    @Size(min = 1, max = 50)
    private String username;

    private Set<String> authorities;

    public UserDTO() {
        super();
    }

    public UserDTO(MyUser user) {
        super();
        this.id = user.getId();
        this.username = user.getUsername();
        this.authorities = user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet());
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

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
