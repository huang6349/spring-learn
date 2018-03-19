package org.hyl.service;

import org.hyl.commons.errors.DataAlreadyExistException;
import org.hyl.domain.Dict;
import org.hyl.repository.DictRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DictService {

    private final Logger logger = LoggerFactory.getLogger(DictService.class);

    @Autowired
    private DictRepository dictRepository;

    public Dict save(Dict dict) {
        logger.debug("保存数据：{}", dict);
        if (dictRepository.findOneByIdentIgnoreCase(dict.getIdent()).isPresent()) {
            throw new DataAlreadyExistException("字典标识[" + dict.getIdent() + "]已经存在");
        }
        return dictRepository.save(dict);
    }
}
