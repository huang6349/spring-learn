package org.hyl.web.rest.errors;

import org.hyl.commons.domain.ResultEntity;
import org.hyl.commons.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandling {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandling.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity handleException(Exception ex) {
        if (ex instanceof BadRequestAlertException) {
            return ResultUtil.error(ex.getMessage());
        }
        logger.error("系统异常：{}", ex);
        return ResultUtil.error("未知错误");
    }
}
