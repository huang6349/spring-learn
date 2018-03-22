package org.hyl.commons.errors;

import org.hyl.commons.result.enums.Result;

public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = 3729783508569808871L;

    private Result.Type type = Result.Type.DEFAULT;

    private Integer state = 500;

    private Object params;

    private Object data;

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Result.Type type) {
        super(message);
        this.type = type;
    }

    public InternalServerErrorException(String message, Integer state) {
        super(message);
        this.state = state;
    }

    public InternalServerErrorException(String message, Object params) {
        super(message);
        this.params = params;
    }

    public InternalServerErrorException(String message, Result.Type type, Integer state) {
        super(message);
        this.type = type;
        this.state = state;
    }

    public InternalServerErrorException(String message, Result.Type type, Object params) {
        super(message);
        this.type = type;
        this.params = params;
    }

    public InternalServerErrorException(String message, Integer state, Object params) {
        super(message);
        this.state = state;
        this.params = params;
    }

    public InternalServerErrorException(String message, Object params, Object data) {
        super(message);
        this.data = data;
        this.params = params;
    }

    public InternalServerErrorException(String message, Result.Type type, Integer state, Object params) {
        super(message);
        this.type = type;
        this.state = state;
        this.params = params;
    }

    public InternalServerErrorException(String message, Integer state, Object params, Object data) {
        super(message);
        this.state = state;
        this.params = params;
        this.data = data;
    }

    public InternalServerErrorException(String message, Result.Type type, Integer state, Object params, Object data) {
        super(message);
        this.type = type;
        this.state = state;
        this.params = params;
        this.data = data;
    }

    public Result.Type getType() {
        return type;
    }

    public void setType(Result.Type type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
