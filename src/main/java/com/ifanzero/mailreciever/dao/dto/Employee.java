package com.ifanzero.mailreciever.dao.dto;

public class Employee {


    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号码
     */
    private String telephone;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 居住地
     */
    private String addr;
    /**
     * 求职状态
     */
    private String employStatus;
    /**
     * 求职意向
     */
    private String employAim;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmployStatus() {
        return employStatus;
    }

    public void setEmployStatus(String employStatus) {
        this.employStatus = employStatus;
    }

    public String getEmployAim() {
        return employAim;
    }

    public void setEmployAim(String employAim) {
        this.employAim = employAim;
    }
}
