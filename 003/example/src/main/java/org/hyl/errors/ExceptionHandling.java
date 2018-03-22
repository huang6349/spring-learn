package org.hyl.errors;

import org.hyl.commons.result.domain.ResultEntity;
import org.hyl.commons.errors.InternalServerErrorException;
import org.hyl.commons.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = InternalServerErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultEntity handleInternalServerErrorException(InternalServerErrorException e) {
        return ResultUtil.error(e.getType(), e.getClass().getName(), e.getState(), e.getMessage(), e.getData(), e.getParams());
    }
}
