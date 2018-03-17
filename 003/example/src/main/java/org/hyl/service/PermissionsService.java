package org.hyl.service;

import org.hyl.domain.Permissions;
import org.hyl.repository.PermissionsRepository;
import org.hyl.repository.UserRepository;
import org.hyl.security.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PermissionsService {

    private final Logger logger = LoggerFactory.getLogger(PermissionsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionsRepository permissionsRepository;

    @Transactional(readOnly = true)
    public Optional<List<Permissions>> getUserPermissions() {
        return SecurityUtils.getCurrentUserUsername()
                .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                .map(user -> permissionsRepository.findByAuthoritiesIn(user.getAuthorities())
                        .stream()
                        .distinct()
                        .collect(Collectors.toList())
                );
    }
}
