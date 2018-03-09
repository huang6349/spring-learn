package org.hyl.service;

import org.hyl.domain.Authority;
import org.hyl.domain.MyUser;
import org.hyl.repository.AuthorityRepository;
import org.hyl.repository.UserRepository;
import org.hyl.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    public MyUser create(UserDTO userDTO) {
        MyUser user = new MyUser();
        user.setUsername(userDTO.getUsername());
        if (userDTO.getAuthorities() != null) {
            Set<Authority> authorities = userDTO.getAuthorities().stream().map(authorityRepository::findOne).collect(Collectors.toSet());
            user.setAuthorities(authorities);
        }
        user.setPassword("123456");
        userRepository.save(user);
        logger.debug("创建用户信息：{}", user);
        return user;
    }
}
