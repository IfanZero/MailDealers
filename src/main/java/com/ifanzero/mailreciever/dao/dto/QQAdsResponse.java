package com.ifanzero.mailreciever.dao.dto;

public class QQAdsResponse {
    private static final String SUCCESS="success";
    private static final String FAIL="fail";
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
