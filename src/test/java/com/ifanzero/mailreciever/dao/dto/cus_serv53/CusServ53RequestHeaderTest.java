package com.ifanzero.mailreciever.dao.dto.cus_serv53;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class CusServ53RequestHeaderTest {

    @Test
    public void transJson() {
        //language=JSON
        String jsonStr = "{\"cmd\":\"customer\",\"token\":\"qweasdzxc\",\"guest_id\":1003564742,\"guest_name\":\"name\",\"mobile\":15224701589,\"email\":\"\",\"province\":\"\",\"city\":\"\",\"address\":\"\",\"zipcode\":\"\"}";
        //language=JSON
        String jsonStr2 = "{\n" +
                "  \"content\": {\n" +
                "    \"message\": [\n" +
                "      {\n" +
                "        \"worker_name\": \"Miss郑\",\n" +
                "        \"company_id\": \"72140486\",\n" +
                "        \"msg_type\": \"p\",\n" +
                "        \"id6d\": \"10200288\",\n" +
                "        \"talk_id\": \"96636357808\",\n" +
                "        \"worker_id\": \"2445713491@qq.com\",\n" +
                "        \"msg\": \"<p><span style=\\\"font-family: 宋体;\\\"><strong>欢迎访问善班官网！</strong></span></p><p><span style=\\\"font-family: 宋体;\\\"><strong>高薪岗位等你来，专业技能 商业实战 签约保就业，不就业退费，免费试听，快速收获1-2年职场实战经验！</strong></span></p><p><span style=\\\"font-family: 宋体;\\\"><br /><strong>【姓名 电话】即可免费体验善班训练营，秒抢价值3980元课程，限时免费！快来抢吧！</strong></span></p><p>&nbsp;</p>\",\n" +
                "        \"msg_time\": \"20161228143820\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"worker_name\": \"Miss郑\",\n" +
                "        \"company_id\": \"72140486\",\n" +
                "        \"msg_type\": \"p\",\n" +
                "        \"id6d\": \"10200288\",\n" +
                "        \"talk_id\": \"96636357808\",\n" +
                "        \"worker_id\": \"2445713491@qq.com\",\n" +
                "        \"msg\": \"您好，我是善班财务信息化就业指导郑老师，请问有什么可以帮到您吗？\",\n" +
                "        \"msg_time\": \"20161228143833\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"session\": {\n" +
                "      \"kw\": \"erp系统是什么\",\n" +
                "      \"company_id\": \"72140486\",\n" +
                "      \"guest_area\": \"广东省广州市[联通]\",\n" +
                "      \"guest_id\": \"10045729130017\",\n" +
                "      \"talk_id\": \"96636357808\",\n" +
                "      \"id6d\": \"10200288\",\n" +
                "      \"guest_ip\": \"58.248.58.131\",\n" +
                "      \"se\": \"360\",\n" +
                "      \"worker_name\": null,\n" +
                "      \"talk_type\": \"5\",\n" +
                "      \"talk_page\": \"https://www.so.com/s?src=360chrome_newtab_search&ie=utf-8&q=erp%E7%B3%BB%E7%BB%9F%E6%98%AF%E4%BB%80%E4%B9%88\",\n" +
                "      \"device\": \"1\",\n" +
                "      \"referer\": \"http://tg.shanbane.com/?adcode=gz360pc10151\",\n" +
                "      \"worker_id\": \"2445713491@qq.com\",\n" +
                "      \"talk_time\": \"20161228143820\"\n" +
                "    },\n" +
                "    \"end\": {\n" +
                "      \"company_id\": \"72140486\",\n" +
                "      \"end_time\": \"20161228143919\",\n" +
                "      \"end_type\": \"3\",\n" +
                "      \"talk_id\": \"96636357808\"\n" +
                "    }\n" +
                "  },\n" +
                "\n" +
                "  \"msg_id\":\"da9b1ca7-1400-477f-b5ef-2259bbb4077e\",\n" +
                "  \"cmd\":\"talk_info\",\n" +
                "  \"token\":\"qweasdzxc\"\n" +
                "}";

        CusServ53RequestHeader cusServ53RequestHeader = JSONUtil.toBean(jsonStr,CusServ53RequestHeader.class);
        CusServ53RequestHeader cusServ53RequestHeader2 = JSONUtil.toBean(jsonStr2,CusServ53RequestHeader.class);
        if ("talk_info".equals(cusServ53RequestHeader2.getCmd())){
            CusServ53AllHeader cusServ53AllHeader = JSONUtil.toBean(jsonStr2,CusServ53AllHeader.class);
            assertEquals("qweasdzxc",cusServ53AllHeader.getToken());
        }
        if ("customer".equals(cusServ53RequestHeader.getCmd())){
            assertNotNull(cusServ53RequestHeader);
        }

    }
}