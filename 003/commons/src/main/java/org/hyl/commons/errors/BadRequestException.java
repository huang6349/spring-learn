package org.hyl.commons.errors;

import org.hyl.commons.result.enums.Result;

public class BadRequestException extends InternalServerErrorException {

    private static final long serialVersionUID = 4324634744015028935L;

    private static final Integer STATE = 400;

    public BadRequestException(String message) {
        super(message, STATE);
    }

    public BadRequestException(String message, Result.Type type) {
        super(message, type, STATE);
    }

    public BadRequestException(String message, Result.Type type, Object params) {
        super(message, type, STATE, params);
    }

    public BadRequestException(String message, Result.Type type, Object params, Object data) {
        super(message, type, STATE, params, data);
    }
}
