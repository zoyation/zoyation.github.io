package com.fruit.common.dto.result;

/**
 * app接口统一返回参数对象
 * Created by zoyation on 2017-08-26.
 */
public class AppJsonResult<T> {
    //成功标志
    private boolean success = true;
    //提示信息
    private String msg;
    //错误信息
    private String error;
    //返回数据
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
