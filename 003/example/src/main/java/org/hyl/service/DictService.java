package org.hyl.service;

import org.hyl.base.level.LevelUtil;
import org.hyl.commons.errors.DataAlreadyExistException;
import org.hyl.domain.Dict;
import org.hyl.repository.DictRepository;
import org.hyl.service.dto.DictDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DictService {

    private final Logger logger = LoggerFactory.getLogger(DictService.class);

    private final DictRepository dictRepository;

    @Autowired
    public DictService(DictRepository dictRepository) {
        this.dictRepository = dictRepository;
    }

    public DictDTO save(DictDTO dto) {
        logger.debug("保存数据：{}", dto);
        if (dictRepository.findOneByIdentIgnoreCase(dto.getIdent()).isPresent()) {
            throw new DataAlreadyExistException("字典标识[" + dto.getIdent() + "]已经存在");
        }
        Dict dict = new Dict();
        BeanUtils.copyProperties(dto, dict);
        dict.setLevel(LevelUtil.calculateLevel(getLevel(dict.getPid()), dict.getPid()));
        return DictDTO.adapt(dictRepository.save(dict));
    }

    private String getLevel(Long id) {
        return Optional.of(id).map(dictRepository::findOne).map(Dict::getLevel).orElse(null);
    }
}
