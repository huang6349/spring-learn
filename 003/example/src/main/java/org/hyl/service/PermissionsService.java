package org.hyl.service;

import org.hyl.utils.impl.LevelUtilImpl;
import org.hyl.repository.PermissionsRepository;
import org.hyl.repository.UserRepository;
import org.hyl.security.SecurityUtils;
import org.hyl.service.dto.PermissionsLevelDTO;
import org.hyl.utils.LevelUtil;
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

    private LevelUtil<PermissionsLevelDTO> levelService = new LevelUtilImpl<>();

    private final UserRepository userRepository;

    private final PermissionsRepository permissionsRepository;

    @Autowired
    public PermissionsService(PermissionsRepository permissionsRepository, UserRepository userRepository) {
        this.permissionsRepository = permissionsRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<List<PermissionsLevelDTO>> getUserPermissions() {
        return SecurityUtils.getCurrentUserUsername()
                .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                .map(user -> levelService.listToTree(permissionsRepository.findByAuthoritiesIn(user.getAuthorities())
                        .stream()
                        .distinct()
                        .map(PermissionsLevelDTO::adapt)
                        .collect(Collectors.toList()))
                );
    }
}
