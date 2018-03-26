package org.hyl.web.rest;

import org.hyl.commons.result.domain.Message;
import org.hyl.commons.result.enums.Result;
import org.hyl.commons.errors.DataAlreadyIDException;
import org.hyl.commons.result.ResultUtil;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DictResource {

    private final Logger logger = LoggerFactory.getLogger(DictResource.class);

    private final DictRepository dictRepository;

    private final DictService dictService;

    @Autowired
    public DictResource(DictRepository dictRepository, DictService dictService) {
        this.dictRepository = dictRepository;
        this.dictService = dictService;
    }

    @PostMapping("/admin/dict")
    @Secured("ADMIN")
    public Message create(@Valid @RequestBody DictDTO dto) {
        logger.debug("新增数据字典：{}", dto);
        if (dto.getId() != null) {
            throw new DataAlreadyIDException();
        }
        return ResultUtil.success(Result.Type.POST, dictService.save(dto));
    }

    @GetMapping("/api/dict")
    public Message query(Pageable pageable) {
        final Page<Dict> page = dictRepository.findAll(pageable);
        return ResultUtil.success(page.getContent());
    }
}
