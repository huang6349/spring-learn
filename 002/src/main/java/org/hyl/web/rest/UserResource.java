package org.hyl.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hyl.commons.domain.ResultEntity;
import org.hyl.commons.utils.ResultUtil;
import org.hyl.domain.MyUser;
import org.hyl.repository.UserRepository;
import org.hyl.security.AuthoritiesConstants;
import org.hyl.service.UserService;
import org.hyl.service.dto.UserDTO;
import org.hyl.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api("用户管理")
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @ApiOperation("添加数据")
    @PostMapping("/users")
    @Secured(AuthoritiesConstants.ADMIN)
    public ResultEntity create(@Valid @RequestBody UserDTO userDTO) {
        if (userDTO.getId() != null) {
            throw new BadRequestAlertException("新增数据不能存在ID");
        }
        if (userRepository.findOneByUsername(userDTO.getUsername().toLowerCase()).isPresent()) {
            throw new BadRequestAlertException("用户名已经存在");
        }
        MyUser user = userService.create(userDTO);
        return ResultUtil.success(user);
    }
}
