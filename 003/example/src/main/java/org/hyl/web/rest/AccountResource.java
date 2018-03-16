package org.hyl.web.rest;

import org.hyl.commons.domain.ResultEntity;
import org.hyl.commons.utils.ResultUtil;
import org.hyl.domain.Permissions;
import org.hyl.errors.InternalServerErrorException;
import org.hyl.service.PermissionsService;
import org.hyl.service.UserService;
import org.hyl.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountResource {

    private final Logger logger = LoggerFactory.getLogger(AccountResource.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionsService permissionsService;

    @GetMapping("/account")
    public ResultEntity getAccount() {
        return userService.getUserWithAuthorities()
                .map(user -> ResultUtil.success(new UserDTO(user)))
                .orElseThrow(() -> new InternalServerErrorException("未找到用户信息"));
    }

    @GetMapping("/authorities")
    public ResultEntity getAuthorities() {
        return permissionsService.getUserPermissions()
                .map(ResultUtil::success)
                .orElseThrow(() -> new InternalServerErrorException("获取用户权限失败"));
    }
}
