package org.hyl.web.rest.vm;

import org.hyl.service.dto.UserDTO;

import javax.validation.constraints.Size;

public class ManagedUserVM extends UserDTO {

    @Size(max = 60)
    private String password;

    public ManagedUserVM() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
