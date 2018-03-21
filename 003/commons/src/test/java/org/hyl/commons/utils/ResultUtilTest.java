package org.hyl.commons.utils;

import org.hyl.commons.result.ResultUtil;
import org.hyl.commons.result.domain.ResultEntity;
import org.hyl.commons.result.enums.Result;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultUtilTest {

    private Integer state;

    private String message;

    private String error;

    private List<String> data = new ArrayList<>();

    private Map<String, Integer> map = new HashMap<>();

    @Before
    public void setup() {
        state = 200;
        message = "TEST";
        data.add("1");
        data.add("2");
        data.add("3");
        map.put("id", 1);
        error = new RuntimeException("ERROR").getMessage();
    }

    @Test
    public void success0() throws Exception {
        ResultEntity a = ResultUtil.success();
        ResultEntity b = new ResultEntity();
        b.setState(Result.SUCCESS.getState());
        b.setMessage(Result.SUCCESS.getMessage());
        b.setData(null);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success1() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.SUCCESS.getState());
        b1.setMessage(Result.SUCCESS.getMessage());
        b1.setData(null);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.SUCCESS_POST.getState());
        b2.setMessage(Result.SUCCESS_POST.getMessage());
        b2.setData(null);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.SUCCESS_DELETE.getState());
        b3.setMessage(Result.SUCCESS_DELETE.getMessage());
        b3.setData(null);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.SUCCESS_GET.getState());
        b4.setMessage(Result.SUCCESS_GET.getMessage());
        b4.setData(null);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.SUCCESS_PUT.getState());
        b5.setMessage(Result.SUCCESS_PUT.getMessage());
        b5.setData(null);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success2() throws Exception {
        ResultEntity a = ResultUtil.success(state);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(Result.SUCCESS.getMessage());
        b.setData(null);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success3() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, state);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(Result.SUCCESS.getMessage());
        b1.setData(null);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, state);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(Result.SUCCESS_POST.getMessage());
        b2.setData(null);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, state);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(Result.SUCCESS_DELETE.getMessage());
        b3.setData(null);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, state);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(Result.SUCCESS_GET.getMessage());
        b4.setData(null);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, state);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(Result.SUCCESS_PUT.getMessage());
        b5.setData(null);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success4() throws Exception {
        ResultEntity a = ResultUtil.success(state, data);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(Result.SUCCESS.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success5() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, state, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(Result.SUCCESS.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, state, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(Result.SUCCESS_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, state, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(Result.SUCCESS_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, state, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(Result.SUCCESS_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, state, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(Result.SUCCESS_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success6() throws Exception {
        ResultEntity a = ResultUtil.success(state, data, map);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(Result.SUCCESS.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void success7() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, state, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(Result.SUCCESS.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, state, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(Result.SUCCESS_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, state, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(Result.SUCCESS_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, state, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(Result.SUCCESS_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, state, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(Result.SUCCESS_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(map);
        test(a5, b5);
    }

    @Test
    public void success8() throws Exception {
        ResultEntity a = ResultUtil.success(message);
        ResultEntity b = new ResultEntity();
        b.setState(Result.SUCCESS.getState());
        b.setMessage(message);
        b.setData(null);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success9() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, message);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.SUCCESS.getState());
        b1.setMessage(message);
        b1.setData(null);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, message);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.SUCCESS_POST.getState());
        b2.setMessage(message);
        b2.setData(null);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, message);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.SUCCESS_DELETE.getState());
        b3.setMessage(message);
        b3.setData(null);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, message);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.SUCCESS_GET.getState());
        b4.setMessage(message);
        b4.setData(null);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, message);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.SUCCESS_PUT.getState());
        b5.setMessage(message);
        b5.setData(null);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success10() throws Exception {
        ResultEntity a = ResultUtil.success(message, data);
        ResultEntity b = new ResultEntity();
        b.setState(Result.SUCCESS.getState());
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success11() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, message, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.SUCCESS.getState());
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, message, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.SUCCESS_POST.getState());
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, message, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.SUCCESS_DELETE.getState());
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, message, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.SUCCESS_GET.getState());
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, message, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.SUCCESS_PUT.getState());
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success12() throws Exception {
        ResultEntity a = ResultUtil.success(message, data, map);
        ResultEntity b = new ResultEntity();
        b.setState(Result.SUCCESS.getState());
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void success13() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, message, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.SUCCESS.getState());
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, message, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.SUCCESS_POST.getState());
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, message, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.SUCCESS_DELETE.getState());
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, message, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.SUCCESS_GET.getState());
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, message, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.SUCCESS_PUT.getState());
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(map);
        test(a5, b5);
    }

    @Test
    public void success14() throws Exception {
        ResultEntity a = ResultUtil.success(state, message);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(message);
        b.setData(null);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success15() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, state, message);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(message);
        b1.setData(null);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, state, message);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(message);
        b2.setData(null);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, state, message);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(message);
        b3.setData(null);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, state, message);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(message);
        b4.setData(null);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, state, message);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(message);
        b5.setData(null);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success16() throws Exception {
        ResultEntity a = ResultUtil.success(state, message, data);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success17() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, state, message, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, state, message, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, state, message, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, state, message, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, state, message, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success18() throws Exception {
        ResultEntity a = ResultUtil.success(state, message, data, map);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void success19() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, state, message, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, state, message, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, state, message, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, state, message, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, state, message, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(map);
        test(a5, b5);
    }

    @Test
    public void success20() throws Exception {
        ResultEntity a = ResultUtil.success(data);
        ResultEntity b = new ResultEntity();
        b.setState(Result.SUCCESS.getState());
        b.setMessage(Result.SUCCESS.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void success21() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.SUCCESS.getState());
        b1.setMessage(Result.SUCCESS.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.SUCCESS_POST.getState());
        b2.setMessage(Result.SUCCESS_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.SUCCESS_DELETE.getState());
        b3.setMessage(Result.SUCCESS_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.SUCCESS_GET.getState());
        b4.setMessage(Result.SUCCESS_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.SUCCESS_PUT.getState());
        b5.setMessage(Result.SUCCESS_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void success22() throws Exception {
        ResultEntity a = ResultUtil.success(data, map);
        ResultEntity b = new ResultEntity();
        b.setState(Result.SUCCESS.getState());
        b.setMessage(Result.SUCCESS.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.SUCCESS.isSuccess());
        b.setE(null);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void success23() throws Exception {
        ResultEntity a1 = ResultUtil.success(Result.Type.DEFAULT, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.SUCCESS.getState());
        b1.setMessage(Result.SUCCESS.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.SUCCESS.isSuccess());
        b1.setE(null);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.success(Result.Type.POST, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.SUCCESS_POST.getState());
        b2.setMessage(Result.SUCCESS_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.SUCCESS.isSuccess());
        b2.setE(null);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.success(Result.Type.DELETE, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.SUCCESS_DELETE.getState());
        b3.setMessage(Result.SUCCESS_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.SUCCESS.isSuccess());
        b3.setE(null);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.success(Result.Type.GET, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.SUCCESS_GET.getState());
        b4.setMessage(Result.SUCCESS_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.SUCCESS.isSuccess());
        b4.setE(null);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.success(Result.Type.PUT, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.SUCCESS_PUT.getState());
        b5.setMessage(Result.SUCCESS_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.SUCCESS.isSuccess());
        b5.setE(null);
        b5.setParams(map);
        test(a5, b5);
    }

    @Test
    public void error0() throws Exception {
        ResultEntity a = ResultUtil.error(error);
        ResultEntity b = new ResultEntity();
        b.setState(Result.ERROR.getState());
        b.setMessage(Result.ERROR.getMessage());
        b.setData(null);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error1() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.ERROR.getState());
        b1.setMessage(Result.ERROR.getMessage());
        b1.setData(null);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.ERROR_POST.getState());
        b2.setMessage(Result.ERROR_POST.getMessage());
        b2.setData(null);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.ERROR_DELETE.getState());
        b3.setMessage(Result.ERROR_DELETE.getMessage());
        b3.setData(null);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.ERROR_GET.getState());
        b4.setMessage(Result.ERROR_GET.getMessage());
        b4.setData(null);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.ERROR_PUT.getState());
        b5.setMessage(Result.ERROR_PUT.getMessage());
        b5.setData(null);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error2() throws Exception {
        ResultEntity a = ResultUtil.error(error, state);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(Result.ERROR.getMessage());
        b.setData(null);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error3() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, state);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(Result.ERROR.getMessage());
        b1.setData(null);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, state);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(Result.ERROR_POST.getMessage());
        b2.setData(null);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, state);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(Result.ERROR_DELETE.getMessage());
        b3.setData(null);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, state);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(Result.ERROR_GET.getMessage());
        b4.setData(null);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, state);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(Result.ERROR_PUT.getMessage());
        b5.setData(null);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error4() throws Exception {
        ResultEntity a = ResultUtil.error(error, state, data);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(Result.ERROR.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error5() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, state, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(Result.ERROR.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, state, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(Result.ERROR_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, state, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(Result.ERROR_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, state, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(Result.ERROR_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, state, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(Result.ERROR_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error6() throws Exception {
        ResultEntity a = ResultUtil.error(error, state, data, map);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(Result.ERROR.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void error7() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, state, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(Result.ERROR.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, state, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(Result.ERROR_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, state, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(Result.ERROR_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, state, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(Result.ERROR_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, state, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(Result.ERROR_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(map);
        test(a5, b5);
    }

    @Test
    public void error8() throws Exception {
        ResultEntity a = ResultUtil.error(error, message);
        ResultEntity b = new ResultEntity();
        b.setState(Result.ERROR.getState());
        b.setMessage(message);
        b.setData(null);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error9() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, message);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.ERROR.getState());
        b1.setMessage(message);
        b1.setData(null);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, message);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.ERROR_POST.getState());
        b2.setMessage(message);
        b2.setData(null);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, message);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.ERROR_DELETE.getState());
        b3.setMessage(message);
        b3.setData(null);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, message);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.ERROR_GET.getState());
        b4.setMessage(message);
        b4.setData(null);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, message);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.ERROR_PUT.getState());
        b5.setMessage(message);
        b5.setData(null);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error10() throws Exception {
        ResultEntity a = ResultUtil.error(error, message, data);
        ResultEntity b = new ResultEntity();
        b.setState(Result.ERROR.getState());
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error11() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, message, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.ERROR.getState());
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, message, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.ERROR_POST.getState());
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, message, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.ERROR_DELETE.getState());
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, message, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.ERROR_GET.getState());
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, message, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.ERROR_PUT.getState());
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error12() throws Exception {
        ResultEntity a = ResultUtil.error(error, message, data, map);
        ResultEntity b = new ResultEntity();
        b.setState(Result.ERROR.getState());
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void error13() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, message, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.ERROR.getState());
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, message, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.ERROR_POST.getState());
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, message, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.ERROR_DELETE.getState());
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, message, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.ERROR_GET.getState());
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, message, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.ERROR_PUT.getState());
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(map);
        test(a5, b5);
    }

    @Test
    public void error14() throws Exception {
        ResultEntity a = ResultUtil.error(error, state, message);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(message);
        b.setData(null);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error15() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, state, message);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(message);
        b1.setData(null);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, state, message);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(message);
        b2.setData(null);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, state, message);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(message);
        b3.setData(null);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, state, message);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(message);
        b4.setData(null);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, state, message);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(message);
        b5.setData(null);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error16() throws Exception {
        ResultEntity a = ResultUtil.error(error, state, message, data);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error17() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, state, message, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, state, message, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, state, message, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, state, message, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, state, message, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error18() throws Exception {
        ResultEntity a = ResultUtil.error(error, state, message, data, map);
        ResultEntity b = new ResultEntity();
        b.setState(state);
        b.setMessage(message);
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void error19() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, state, message, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(state);
        b1.setMessage(message);
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, state, message, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(state);
        b2.setMessage(message);
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, state, message, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(state);
        b3.setMessage(message);
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, state, message, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(state);
        b4.setMessage(message);
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, state, message, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(state);
        b5.setMessage(message);
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(map);
        test(a5, b5);
    }

    @Test
    public void error20() throws Exception {
        ResultEntity a = ResultUtil.error(error, data);
        ResultEntity b = new ResultEntity();
        b.setState(Result.ERROR.getState());
        b.setMessage(Result.ERROR.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(null);
        test(a, b);
    }

    @Test
    public void error21() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, data);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.ERROR.getState());
        b1.setMessage(Result.ERROR.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(null);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, data);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.ERROR_POST.getState());
        b2.setMessage(Result.ERROR_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(null);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, data);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.ERROR_DELETE.getState());
        b3.setMessage(Result.ERROR_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(null);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, data);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.ERROR_GET.getState());
        b4.setMessage(Result.ERROR_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(null);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, data);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.ERROR_PUT.getState());
        b5.setMessage(Result.ERROR_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(null);
        test(a5, b5);
    }

    @Test
    public void error22() throws Exception {
        ResultEntity a = ResultUtil.error(error, data, map);
        ResultEntity b = new ResultEntity();
        b.setState(Result.ERROR.getState());
        b.setMessage(Result.ERROR.getMessage());
        b.setData(data);
        b.setSuccess(Result.Network.ERROR.isSuccess());
        b.setE(error);
        b.setParams(map);
        test(a, b);
    }

    @Test
    public void error23() throws Exception {
        ResultEntity a1 = ResultUtil.error(Result.Type.DEFAULT, error, data, map);
        ResultEntity b1 = new ResultEntity();
        b1.setState(Result.ERROR.getState());
        b1.setMessage(Result.ERROR.getMessage());
        b1.setData(data);
        b1.setSuccess(Result.Network.ERROR.isSuccess());
        b1.setE(error);
        b1.setParams(map);
        test(a1, b1);
        ResultEntity a2 = ResultUtil.error(Result.Type.POST, error, data, map);
        ResultEntity b2 = new ResultEntity();
        b2.setState(Result.ERROR_POST.getState());
        b2.setMessage(Result.ERROR_POST.getMessage());
        b2.setData(data);
        b2.setSuccess(Result.Network.ERROR.isSuccess());
        b2.setE(error);
        b2.setParams(map);
        test(a2, b2);
        ResultEntity a3 = ResultUtil.error(Result.Type.DELETE, error, data, map);
        ResultEntity b3 = new ResultEntity();
        b3.setState(Result.ERROR_DELETE.getState());
        b3.setMessage(Result.ERROR_DELETE.getMessage());
        b3.setData(data);
        b3.setSuccess(Result.Network.ERROR.isSuccess());
        b3.setE(error);
        b3.setParams(map);
        test(a3, b3);
        ResultEntity a4 = ResultUtil.error(Result.Type.GET, error, data, map);
        ResultEntity b4 = new ResultEntity();
        b4.setState(Result.ERROR_GET.getState());
        b4.setMessage(Result.ERROR_GET.getMessage());
        b4.setData(data);
        b4.setSuccess(Result.Network.ERROR.isSuccess());
        b4.setE(error);
        b4.setParams(map);
        test(a4, b4);
        ResultEntity a5 = ResultUtil.error(Result.Type.PUT, error, data, map);
        ResultEntity b5 = new ResultEntity();
        b5.setState(Result.ERROR_PUT.getState());
        b5.setMessage(Result.ERROR_PUT.getMessage());
        b5.setData(data);
        b5.setSuccess(Result.Network.ERROR.isSuccess());
        b5.setE(error);
        b5.setParams(map);
        test(a5, b5);
    }

    private void test(ResultEntity a, ResultEntity b) {
        assertThat(a.getState()).isEqualTo(b.getState());
        assertThat(a.getMessage()).isEqualTo(b.getMessage());
        assertThat(a.getData()).isEqualTo(b.getData());
        assertThat(a.getSuccess()).isEqualTo(b.getSuccess());
        assertThat(a.getE()).isEqualTo(b.getE());
        assertThat(a.getParams()).isEqualTo(b.getParams());
    }
}