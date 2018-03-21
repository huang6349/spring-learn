package org.hyl.errors;

import org.hyl.commons.result.domain.ResultEntity;
import org.hyl.commons.errors.InternalServerErrorException;
import org.hyl.commons.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandling {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandling.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error("[{}]发生错误：{}", request.getRequestURI(), e.getMessage());
        if (e instanceof InternalServerErrorException) {
            InternalServerErrorException ex = (InternalServerErrorException) e;
            return ResultUtil.error(ex.getType(), ex.getClass().getSimpleName(), ex.getState(), e.getMessage(), ex.getData(), ex.getParams());
        }
        return ResultUtil.error(e.getMessage());
    }
}
