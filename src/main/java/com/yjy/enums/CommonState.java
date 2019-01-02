package com.yjy.enums;

public enum CommonState {
    INNER_ERROR(-10,"系统错误"),
    INPUT_NULL(-9, "输入空值"),

    LOGIN_SUCCESS(1,"登录成功"),
    PSWD_INCORRECT(-1,"密码错误"),
    USER_NOT_FOUND(-5,"用户不存在"),

    REGIST_SUCCESS(2,"注册成功"),
    NAME_REGISTERED(-2,"已被注册"),
    NAME_NULL(-3,"用户名为空"),
    PSWD_NULL(-4,"密码为空")
    ;

    private int state;
    private String stateInfo;

    CommonState(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static CommonState stateOf(int index) {
        for (CommonState state : values()) {
            if (state.state == index) {
                return state;
            }
        }
        return null;
    }
}
