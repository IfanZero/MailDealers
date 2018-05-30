package com.ifanzero.mailreciever.dao.dto.cus_serv53;

public class CusServ53AllHeader {
    private String msg_id;
    private String cmd;
    private String token;
    private CusServ53AllContent content;

    public String getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public CusServ53AllContent getContent() {
        return content;
    }

    public void setContent(CusServ53AllContent content) {
        this.content = content;
    }
}
