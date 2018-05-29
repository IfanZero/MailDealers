package com.ifanzero.mailreciever.dao.dto;

import java.util.List;

public class CusServ53Request {

    /**
     * message : [{"worker_name":"Miss郑","company_id":"72140486","msg_type":"p","id6d":"10200288","talk_id":"96636357808","worker_id":"2445713491@qq.com","msg":"<p><span style=\"font-family: 宋体;\"><strong>欢迎访问善班官网！<\/strong><\/span><\/p><p><span style=\"font-family: 宋体;\"><strong>高薪岗位等你来，专业技能 商业实战 签约保就业，不就业退费，免费试听，快速收获1-2年职场实战经验！<\/strong><\/span><\/p><p><span style=\"font-family: 宋体;\"><br /><strong>【姓名 电话】即可免费体验善班训练营，秒抢价值3980元课程，限时免费！快来抢吧！<\/strong><\/span><\/p><p>&nbsp;<\/p>","msg_time":"20161228143820"},{"worker_name":"Miss郑","company_id":"72140486","msg_type":"p","id6d":"10200288","talk_id":"96636357808","worker_id":"2445713491@qq.com","msg":"您好，我是善班财务信息化就业指导郑老师，请问有什么可以帮到您吗？","msg_time":"20161228143833"}]
     * session : {"kw":"erp系统是什么","company_id":"72140486","guest_area":"广东省广州市[联通]","guest_id":"10045729130017","talk_id":"96636357808","id6d":"10200288","guest_ip":"58.248.58.131","se":"360","worker_name":null,"talk_type":"5","talk_page":"https://www.so.com/s?src=360chrome_newtab_search&ie=utf-8&q=erp%E7%B3%BB%E7%BB%9F%E6%98%AF%E4%BB%80%E4%B9%88","device":"1","referer":"http://tg.shanbane.com/?adcode=gz360pc10151","worker_id":"2445713491@qq.com","talk_time":"20161228143820"}
     * end : {"company_id":"72140486","end_time":"20161228143919","end_type":"3","talk_id":"96636357808"}
     */

    private SessionBean session;
    private EndBean end;
    private List<MessageBean> message;
    private String msg_id;
    private String cmd;
    private String token;

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

    public SessionBean getSession() {
        return session;
    }

    public void setSession(SessionBean session) {
        this.session = session;
    }

    public EndBean getEnd() {
        return end;
    }

    public void setEnd(EndBean end) {
        this.end = end;
    }

    public List<MessageBean> getMessage() {
        return message;
    }

    public void setMessage(List<MessageBean> message) {
        this.message = message;
    }

    public static class SessionBean {
        /**
         * kw : erp系统是什么
         * company_id : 72140486
         * guest_area : 广东省广州市[联通]
         * guest_id : 10045729130017
         * talk_id : 96636357808
         * id6d : 10200288
         * guest_ip : 58.248.58.131
         * se : 360
         * worker_name : null
         * talk_type : 5
         * talk_page : https://www.so.com/s?src=360chrome_newtab_search&ie=utf-8&q=erp%E7%B3%BB%E7%BB%9F%E6%98%AF%E4%BB%80%E4%B9%88
         * device : 1
         * referer : http://tg.shanbane.com/?adcode=gz360pc10151
         * worker_id : 2445713491@qq.com
         * talk_time : 20161228143820
         */

        private String kw;
        private String company_id;
        private String guest_area;
        private String guest_id;
        private String talk_id;
        private String id6d;
        private String guest_ip;
        private String se;
        private Object worker_name;
        private String talk_type;
        private String talk_page;
        private String device;
        private String referer;
        private String worker_id;
        private String talk_time;

        public String getKw() {
            return kw;
        }

        public void setKw(String kw) {
            this.kw = kw;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getGuest_area() {
            return guest_area;
        }

        public void setGuest_area(String guest_area) {
            this.guest_area = guest_area;
        }

        public String getGuest_id() {
            return guest_id;
        }

        public void setGuest_id(String guest_id) {
            this.guest_id = guest_id;
        }

        public String getTalk_id() {
            return talk_id;
        }

        public void setTalk_id(String talk_id) {
            this.talk_id = talk_id;
        }

        public String getId6d() {
            return id6d;
        }

        public void setId6d(String id6d) {
            this.id6d = id6d;
        }

        public String getGuest_ip() {
            return guest_ip;
        }

        public void setGuest_ip(String guest_ip) {
            this.guest_ip = guest_ip;
        }

        public String getSe() {
            return se;
        }

        public void setSe(String se) {
            this.se = se;
        }

        public Object getWorker_name() {
            return worker_name;
        }

        public void setWorker_name(Object worker_name) {
            this.worker_name = worker_name;
        }

        public String getTalk_type() {
            return talk_type;
        }

        public void setTalk_type(String talk_type) {
            this.talk_type = talk_type;
        }

        public String getTalk_page() {
            return talk_page;
        }

        public void setTalk_page(String talk_page) {
            this.talk_page = talk_page;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getReferer() {
            return referer;
        }

        public void setReferer(String referer) {
            this.referer = referer;
        }

        public String getWorker_id() {
            return worker_id;
        }

        public void setWorker_id(String worker_id) {
            this.worker_id = worker_id;
        }

        public String getTalk_time() {
            return talk_time;
        }

        public void setTalk_time(String talk_time) {
            this.talk_time = talk_time;
        }
    }

    public static class EndBean {
        /**
         * company_id : 72140486
         * end_time : 20161228143919
         * end_type : 3
         * talk_id : 96636357808
         */

        private String company_id;
        private String end_time;
        private String end_type;
        private String talk_id;

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getEnd_type() {
            return end_type;
        }

        public void setEnd_type(String end_type) {
            this.end_type = end_type;
        }

        public String getTalk_id() {
            return talk_id;
        }

        public void setTalk_id(String talk_id) {
            this.talk_id = talk_id;
        }
    }

    public static class MessageBean {
        /**
         * worker_name : Miss郑
         * company_id : 72140486
         * msg_type : p
         * id6d : 10200288
         * talk_id : 96636357808
         * worker_id : 2445713491@qq.com
         * msg : <p><span style="font-family: 宋体;"><strong>欢迎访问善班官网！</strong></span></p><p><span style="font-family: 宋体;"><strong>高薪岗位等你来，专业技能 商业实战 签约保就业，不就业退费，免费试听，快速收获1-2年职场实战经验！</strong></span></p><p><span style="font-family: 宋体;"><br /><strong>【姓名 电话】即可免费体验善班训练营，秒抢价值3980元课程，限时免费！快来抢吧！</strong></span></p><p>&nbsp;</p>
         * msg_time : 20161228143820
         */

        private String worker_name;
        private String company_id;
        private String msg_type;
        private String id6d;
        private String talk_id;
        private String worker_id;
        private String msg;
        private String msg_time;

        public String getWorker_name() {
            return worker_name;
        }

        public void setWorker_name(String worker_name) {
            this.worker_name = worker_name;
        }

        public String getCompany_id() {
            return company_id;
        }

        public void setCompany_id(String company_id) {
            this.company_id = company_id;
        }

        public String getMsg_type() {
            return msg_type;
        }

        public void setMsg_type(String msg_type) {
            this.msg_type = msg_type;
        }

        public String getId6d() {
            return id6d;
        }

        public void setId6d(String id6d) {
            this.id6d = id6d;
        }

        public String getTalk_id() {
            return talk_id;
        }

        public void setTalk_id(String talk_id) {
            this.talk_id = talk_id;
        }

        public String getWorker_id() {
            return worker_id;
        }

        public void setWorker_id(String worker_id) {
            this.worker_id = worker_id;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getMsg_time() {
            return msg_time;
        }

        public void setMsg_time(String msg_time) {
            this.msg_time = msg_time;
        }
    }
}
