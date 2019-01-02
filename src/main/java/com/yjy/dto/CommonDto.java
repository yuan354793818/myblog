package com.yjy.dto;

import com.yjy.enums.CommonState;

public class CommonDto<T> {
    private T data;
    private boolean success;
    private int state;
    private String info;

    public CommonDto() {
    }

    public CommonDto(boolean success) {
        this.success = success;
    }

    public CommonDto(boolean success, String info) {
        this.success = success;
        this.info = info;
    }

    public CommonDto(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public CommonDto(T data, boolean success, String info) {
        this.data = data;
        this.success = success;
        this.info = info;
    }

    public CommonDto( boolean success, CommonState state) {
        this.success = success;
        this.state = state.getState();
        this.info = state.getStateInfo();
    }

    public CommonDto(T data, boolean success, CommonState state) {
        this.data = data;
        this.success = success;
        this.state = state.getState();
        this.info = state.getStateInfo();
    }

    public CommonDto(T data, boolean success, int state, String info) {
        this.data = data;
        this.success = success;
        this.state = state;
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CommonDto{" +
                "data=" + data +
                ", success=" + success +
                ", state=" + state +
                ", info='" + info + '\'' +
                '}';
    }
}
