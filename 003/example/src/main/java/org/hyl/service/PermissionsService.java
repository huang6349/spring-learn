package org.hyl.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.hyl.utils.LevelUtil;
import org.hyl.repository.PermissionsRepository;
import org.hyl.repository.UserRepository;
import org.hyl.security.SecurityUtils;
import org.hyl.service.dto.PermissionsLevelDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
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
    public Optional<List<PermissionsLevelDTO>> getUserPermissions() {
        return SecurityUtils.getCurrentUserUsername()
                .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                .map(user -> listToTree(permissionsRepository.findByAuthoritiesIn(user.getAuthorities())
                        .stream()
                        .distinct()
                        .map(PermissionsLevelDTO::adapt)
                        .collect(Collectors.toList()))
                );
    }

    private List<PermissionsLevelDTO> listToTree(List<PermissionsLevelDTO> permissionsLevelDTOS) {
        if (CollectionUtils.isEmpty(permissionsLevelDTOS)) {
            return Lists.newArrayList();
        }
        Multimap<String, PermissionsLevelDTO> levelMap = ArrayListMultimap.create();
        List<PermissionsLevelDTO> rootList = Lists.newArrayList();
        permissionsLevelDTOS.forEach(dto -> {
            levelMap.put(dto.getLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        });
        transformTree(rootList, LevelUtil.ROOT, levelMap);
        return rootList.stream().sorted(Comparator.comparingInt(PermissionsLevelDTO::getSeq)).collect(Collectors.toList());
    }

    private void transformTree(List<PermissionsLevelDTO> dtos, String level, Multimap<String, PermissionsLevelDTO> levelMap) {
        dtos.forEach(dto -> {
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<PermissionsLevelDTO> temps = (List<PermissionsLevelDTO>) levelMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(temps)) {
                dto.setChild(temps);
                transformTree(temps, nextLevel, levelMap);
            }
        });
    }
}
