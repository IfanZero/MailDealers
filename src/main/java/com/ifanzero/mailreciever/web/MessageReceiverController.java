package com.ifanzero.mailreciever.web;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.ifanzero.mailreciever.dao.dto.QQAdsResponse;
import com.ifanzero.mailreciever.dao.dto.QQadsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Slf4j
@Controller
@RequestMapping("/api")
public class MessageReceiverController {
    @ResponseBody
    @RequestMapping("/qq_ads/message")
    public Object addQQ(@RequestBody QQadsRequest request) {
        log.info(request.toString());
        QQAdsResponse qqAdsResponse = new QQAdsResponse();
        qqAdsResponse.setCode(0);
        qqAdsResponse.setMsg("success");

        /*
        {"data":{"account_id":"123123","order_time":"2017-11-27 00:00:00","url":"http:\/\/flzhan.cn\/?r_id=123_5d43e36f&_bid=2759&isAdvanced=1","data":[{"label":"\u59d3\u540d","value":"\u817e\u8baf\u79d1\u6280\u6709\u9650\u516c\u53f8"},{"label":"\u7535\u8bdd","value":"0755 8601 3388"},{"label":"\u7701\u4efd\/\u57ce\u5e02\/\u884c\u653f\u533a","value":"\u5409\u6797\u7701|\u767d\u5c71\u5e02|\u957f\u767d\u671d\u9c9c\u65cf\u81ea\u6cbb\u53bf"},{"label":"\u591a\u9879\u9009\u62e9","value":"\u591a\u90092|\u591a\u90093"}]}}
         */
       return qqAdsResponse;
    }

    @ResponseBody
    @RequestMapping("/cus_serv_53/message")
    public Object add53(@RequestBody QQadsRequest request) {
        log.info(request.toString());
        QQAdsResponse qqAdsResponse = new QQAdsResponse();
        qqAdsResponse.setCode(0);
        qqAdsResponse.setMsg("success");

        /*
        {"data":{"account_id":"123123","order_time":"2017-11-27 00:00:00","url":"http:\/\/flzhan.cn\/?r_id=123_5d43e36f&_bid=2759&isAdvanced=1","data":[{"label":"\u59d3\u540d","value":"\u817e\u8baf\u79d1\u6280\u6709\u9650\u516c\u53f8"},{"label":"\u7535\u8bdd","value":"0755 8601 3388"},{"label":"\u7701\u4efd\/\u57ce\u5e02\/\u884c\u653f\u533a","value":"\u5409\u6797\u7701|\u767d\u5c71\u5e02|\u957f\u767d\u671d\u9c9c\u65cf\u81ea\u6cbb\u53bf"},{"label":"\u591a\u9879\u9009\u62e9","value":"\u591a\u90092|\u591a\u90093"}]}}
         */

        return qqAdsResponse;
    }
}
