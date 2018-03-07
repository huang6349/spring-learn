package org.hyl.security;

import org.hyl.domain.MyUser;
import org.hyl.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MyUserDetailsService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("进行身份验证 {}", username);
        Optional<MyUser> userFromDatabase = userRepository.findOneWithRolesByUsername(username);
        return userFromDatabase.map(user -> createSpringSecurityUser(username, user)).orElseThrow(() -> new UsernameNotFoundException("用户名" + username + "不存在"));
    }

    private User createSpringSecurityUser(String username, MyUser user) {
        return new User(username, user.getPassword(), user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()));
    }
}
