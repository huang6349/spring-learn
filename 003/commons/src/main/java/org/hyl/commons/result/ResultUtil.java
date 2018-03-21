package org.hyl.commons.result;

import org.hyl.commons.result.domain.ResultEntity;
import org.hyl.commons.result.enums.Result;
import org.hyl.commons.result.service.dto.ResultDTO;

public final class ResultUtil {

    private ResultUtil() {
    }

    public static ResultEntity success() {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, null, null, null, null));
    }

    public static ResultEntity success(Result.Type type) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, null, null, null, null));
    }

    public static ResultEntity success(Integer state) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, state, null, null, null));
    }

    public static ResultEntity success(Result.Type type, Integer state) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, state, null, null, null));
    }

    public static ResultEntity success(Integer state, Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, state, null, data, null));
    }

    public static ResultEntity success(Result.Type type, Integer state, Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, state, null, data, null));
    }

    public static ResultEntity success(Integer state, Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, state, null, data, params));
    }

    public static ResultEntity success(Result.Type type, Integer state, Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, state, null, data, params));
    }

    public static ResultEntity success(String message) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, null, message, null, null));
    }

    public static ResultEntity success(Result.Type type, String message) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, null, message, null, null));
    }

    public static ResultEntity success(String message, Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, null, message, data, null));
    }

    public static ResultEntity success(Result.Type type, String message, Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, null, message, data, null));
    }

    public static ResultEntity success(String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, null, message, data, params));
    }

    public static ResultEntity success(Result.Type type, String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, null, message, data, params));
    }

    public static ResultEntity success(Integer state, String message) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, state, message, null, null));
    }

    public static ResultEntity success(Result.Type type, Integer state, String message) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, state, message, null, null));
    }

    public static ResultEntity success(Integer state, String message, Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, state, message, data, null));
    }

    public static ResultEntity success(Result.Type type, Integer state, String message, Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, state, message, data, null));
    }

    public static ResultEntity success(Integer state, String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, state, message, data, params));
    }

    public static ResultEntity success(Result.Type type, Integer state, String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, state, message, data, params));
    }

    public static ResultEntity success(Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, null, null, data, null));
    }

    public static ResultEntity success(Result.Type type, Object data) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, null, null, data, null));
    }

    public static ResultEntity success(Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, Result.Type.DEFAULT, null, null, data, params));
    }

    public static ResultEntity success(Result.Type type, Object data, Object params) {
        return response(new ResultDTO(Result.Network.SUCCESS, type, null, null, data, params));
    }

    public static ResultEntity error(String e) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, null, null, null, e, null));
    }

    public static ResultEntity error(Result.Type type, String e) {
        return response(new ResultDTO(Result.Network.ERROR, type, null, null, null, e, null));
    }

    public static ResultEntity error(String e, Integer state) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, state, null, null, e, null));
    }

    public static ResultEntity error(Result.Type type, String e, Integer state) {
        return response(new ResultDTO(Result.Network.ERROR, type, state, null, null, e, null));
    }

    public static ResultEntity error(String e, Integer state, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, state, null, data, e, null));
    }

    public static ResultEntity error(Result.Type type, String e, Integer state, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, type, state, null, data, e, null));
    }

    public static ResultEntity error(String e, Integer state, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, state, null, data, e, params));
    }

    public static ResultEntity error(Result.Type type, String e, Integer state, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, type, state, null, data, e, params));
    }

    public static ResultEntity error(String e, String message) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, null, message, null, e, null));
    }

    public static ResultEntity error(Result.Type type, String e, String message) {
        return response(new ResultDTO(Result.Network.ERROR, type, null, message, null, e, null));
    }

    public static ResultEntity error(String e, String message, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, null, message, data, e, null));
    }

    public static ResultEntity error(Result.Type type, String e, String message, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, type, null, message, data, e, null));
    }

    public static ResultEntity error(String e, String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, null, message, data, e, params));
    }

    public static ResultEntity error(Result.Type type, String e, String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, type, null, message, data, e, params));
    }

    public static ResultEntity error(String e, Integer state, String message) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, state, message, null, e, null));
    }

    public static ResultEntity error(Result.Type type, String e, Integer state, String message) {
        return response(new ResultDTO(Result.Network.ERROR, type, state, message, null, e, null));
    }

    public static ResultEntity error(String e, Integer state, String message, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, state, message, data, e, null));
    }

    public static ResultEntity error(Result.Type type, String e, Integer state, String message, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, type, state, message, data, e, null));
    }

    public static ResultEntity error(String e, Integer state, String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, state, message, data, e, params));
    }

    public static ResultEntity error(Result.Type type, String e, Integer state, String message, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, type, state, message, data, e, params));
    }

    public static ResultEntity error(String e, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, null, null, data, e, null));
    }

    public static ResultEntity error(Result.Type type, String e, Object data) {
        return response(new ResultDTO(Result.Network.ERROR, type, null, null, data, e, null));
    }

    public static ResultEntity error(String e, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, Result.Type.DEFAULT, null, null, data, e, params));
    }

    public static ResultEntity error(Result.Type type, String e, Object data, Object params) {
        return response(new ResultDTO(Result.Network.ERROR, type, null, null, data, e, params));
    }

    private static ResultEntity response(ResultDTO resultDTO) {
        Result.Network network = resultDTO.getNetwork();
        Result.Type type = resultDTO.getType();
        ResultEntity result = new ResultEntity();
        result.setState(type.getState(network, resultDTO.getState()));
        result.setMessage(type.getMessage(network, resultDTO.getMessage()));
        result.setData(resultDTO.getData());
        result.setSuccess(network.isSuccess());
        result.setE(resultDTO.getE());
        result.setParams(resultDTO.getParams());
        return result;
    }
}
