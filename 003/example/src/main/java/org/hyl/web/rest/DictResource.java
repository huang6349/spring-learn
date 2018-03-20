package org.hyl.web.rest;

import org.hyl.commons.domain.ResultEntity;
import org.hyl.commons.enums.Result;
import org.hyl.commons.errors.DataAlreadyExistException;
import org.hyl.commons.errors.DataAlreadyIDException;
import org.hyl.commons.utils.ResultUtil;
import org.hyl.domain.Dict;
import org.hyl.repository.DictRepository;
import org.hyl.service.DictService;
import org.hyl.service.dto.DictDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DictResource {

    private final Logger logger = LoggerFactory.getLogger(DictResource.class);

    @Autowired
    private DictRepository dictRepository;

    @Autowired
    private DictService dictService;

    @PostMapping("/admin/dict")
    @Secured("ADMIN")
    public ResultEntity create(@Valid @RequestBody DictDTO dto) {
        logger.debug("新增数据字典：{}", dto);
        if (dto.getId() != null) {
            throw new DataAlreadyIDException();
        }
        return ResultUtil.success(Result.Type.POST, dictService.save(dto));
    }

    @GetMapping("/api/dict")
    public ResultEntity query(Pageable pageable) {
        final Page<Dict> page = dictRepository.findAll(pageable);
        return ResultUtil.success(page.getContent());
    }
}
