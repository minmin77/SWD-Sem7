package com.example.testloginfb.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    @SerializedName("result-code")
    private int resultCode;
    @SerializedName("message")
    private String message;
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(int resultCode, String message, boolean success, T data) {
        this.resultCode = resultCode;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
