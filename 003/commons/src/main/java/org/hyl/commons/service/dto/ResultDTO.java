package org.hyl.commons.service.dto;

import org.hyl.commons.enums.Result;

public class ResultDTO {

    private Result.Network network;

    private Result.Type type;

    private Integer state;

    private String message;

    private Object data;

    private String e;

    private Object params;

    public ResultDTO() {
    }

    public ResultDTO(Result.Network network, Result.Type type, Integer state, String message, Object data, Object params) {
        this.network = network;
        this.type = type;
        this.state = state;
        this.message = message;
        this.data = data;
        this.params = params;
    }

    public ResultDTO(Result.Network network, Result.Type type, Integer state, String message, Object data, String e, Object params) {
        this.network = network;
        this.type = type;
        this.state = state;
        this.message = message;
        this.data = data;
        this.e = e;
        this.params = params;
    }

    public Result.Network getNetwork() {
        return network;
    }

    public void setNetwork(Result.Network network) {
        this.network = network;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
