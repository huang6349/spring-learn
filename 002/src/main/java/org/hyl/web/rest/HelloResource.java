package org.hyl.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hyl.commons.domain.ResultEntity;
import org.hyl.commons.enums.Result;
import org.hyl.commons.utils.ResultUtil;
import org.hyl.domain.Hello;
import org.hyl.repository.HelloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api("你好")
@RestController
@RequestMapping("/api")
public class HelloResource {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloRepository helloRepository;

    @ApiOperation("添加数据")
    @PostMapping("/hello")
    public ResultEntity create(@Valid @RequestBody Hello hello) {
        logger.debug("添加数据 {}", hello);
        Hello result = helloRepository.save(hello);
        return ResultUtil.success(Result.Type.POST, result);
    }

    @ApiOperation("分页查询数据")
    @GetMapping("/hello")
    public ResultEntity getAll(Pageable pageable) {
        logger.debug("分页查询数据");
        Page<Hello> hellos = helloRepository.findAll(pageable);
        return ResultUtil.success(Result.Type.GET, hellos);
    }

    @ApiOperation("根据编号查询数据")
    @GetMapping("/hello/{id}")
    public ResultEntity getById(@PathVariable Long id) {
        logger.debug("根据编号查询数据 {}", id);
        Hello hello = helloRepository.findOne(id);
        return ResultUtil.success(Result.Type.GET, hello);
    }

    @ApiOperation("修改数据")
    @PutMapping("/hello")
    public ResultEntity update(@Valid @RequestBody Hello hello) {
        logger.debug("修改数据 {}", hello);
        Hello result = helloRepository.save(hello);
        return ResultUtil.success(Result.Type.PUT, result);
    }

    @ApiOperation("删除数据")
    @DeleteMapping("/hello/{id}")
    public ResultEntity delete(@PathVariable Long id) {
        logger.debug("删除数据 {}", id);
        helloRepository.delete(id);
        return ResultUtil.success(Result.Type.DELETE);
    }
}
