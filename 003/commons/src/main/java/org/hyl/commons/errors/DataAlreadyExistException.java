package org.hyl.commons.errors;

import org.hyl.commons.result.enums.Result;

public class DataAlreadyExistException extends InternalServerErrorException {

    public static final Integer STATE = 10001;

    public DataAlreadyExistException(String message) {
        super(message, Result.Type.POST, STATE);
    }

    public DataAlreadyExistException(String message, Object params) {
        super(message, Result.Type.POST, STATE, params);
    }

    public DataAlreadyExistException(String message, Object params, Object data) {
        super(message, Result.Type.POST, STATE, params, data);
    }
}
