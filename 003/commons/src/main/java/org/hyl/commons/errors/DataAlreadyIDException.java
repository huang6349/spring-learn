package org.hyl.commons.errors;

import org.hyl.commons.result.enums.Result;

public class DataAlreadyIDException extends InternalServerErrorException {

    private static final long serialVersionUID = 193543111713015568L;

    private static final Integer STATE = 10000;

    public DataAlreadyIDException() {
        super("新增数据不能存在ID", Result.Type.POST, STATE);
    }

    public DataAlreadyIDException(String message) {
        super(message, Result.Type.POST, STATE);
    }

    public DataAlreadyIDException(Object params) {
        super("新增数据不能存在ID", Result.Type.POST, STATE, params);
    }

    public DataAlreadyIDException(String message, Object params) {
        super(message, Result.Type.POST, STATE, params);
    }

    public DataAlreadyIDException(Object params, Object data) {
        super("新增数据不能存在ID", Result.Type.POST, STATE, params, data);
    }

    public DataAlreadyIDException(String message, Object params, Object data) {
        super(message, Result.Type.POST, STATE, params, data);
    }
}
