package org.hyl.web.rest;

import org.hyl.commons.result.domain.ResultEntity;
import org.hyl.commons.errors.InternalServerErrorException;
import org.hyl.commons.result.ResultUtil;
import org.hyl.service.PermissionsService;
import org.hyl.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .map(ResultUtil::success)
                .orElseThrow(() -> new InternalServerErrorException("获取当前用户信息失败，请稍后再试", 404));
    }

    @GetMapping("/authorities")
    public ResultEntity getAuthorities() {
        return permissionsService.getUserPermissions()
                .map(ResultUtil::success)
                .orElseThrow(() -> new InternalServerErrorException("获取当前用户权限失败，请稍后再试", 404));
    }
}
