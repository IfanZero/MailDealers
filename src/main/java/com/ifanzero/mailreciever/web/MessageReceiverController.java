package com.ifanzero.mailreciever.web;

import cn.hutool.json.JSONUtil;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53AllContent;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53AllHeader;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53RequestHeader;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53Response;
import com.ifanzero.mailreciever.dao.dto.qq_ads.QQAdsResponse;
import com.ifanzero.mailreciever.dao.dto.qq_ads.QQadsRequest;
import com.ifanzero.mailreciever.service.CusServ53Service;
import com.ifanzero.mailreciever.service.QQadsService;
import com.ifanzero.mailreciever.util.HttpRUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/api")
public class MessageReceiverController {
    @Resource
    private CusServ53Service cusServ53Service;
    @Resource
    private QQadsService qQadsService;

    @ResponseBody
    @RequestMapping("/qq_ads/message")
    public Object addQQ(HttpServletRequest request, HttpServletResponse response) {

        String body = HttpRUtils.getBody(request);

        QQadsRequest qQadsRequest = JSONUtil.toBean(body, QQadsRequest.class);
        qQadsService.saveAds(qQadsRequest);
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
    public Object add53(HttpServletRequest request, HttpServletResponse response) {
        String body = HttpRUtils.getBody(request);
        CusServ53RequestHeader cusServ53RequestHeader = JSONUtil.toBean(body, CusServ53RequestHeader.class);
        if ("talk_info".equals(cusServ53RequestHeader.getCmd())) {
            CusServ53AllHeader cusServ53AllHeader = JSONUtil.toBean(body, CusServ53AllHeader.class);
            cusServ53Service.saveChannal(cusServ53AllHeader.getContent());
        }
        if ("customer".equals(cusServ53RequestHeader.getCmd())) {
            cusServ53Service.saveBasic(cusServ53RequestHeader);
        }
        log.info("收到请求报文：" + body);
        CusServ53Response response53 = new CusServ53Response();
        response53.setCmd("OK");
        response53.setToken(cusServ53RequestHeader.getToken());
        return response53;
    }
}
