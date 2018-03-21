package org.hyl.service;

import org.hyl.domain.MyUser;
import org.hyl.domain.Permissions;
import org.hyl.repository.PermissionsRepository;
import org.hyl.repository.UserRepository;
import org.hyl.security.SecurityUtils;
import org.hyl.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<UserDTO> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUserUsername()
                .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                .map(UserDTO::adapt);
    }
}
