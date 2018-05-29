package com.ifanzero.mailreciever.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.ifanzero.mailreciever.dao.domain.EmployeeForTrans;
import com.ifanzero.mailreciever.dao.dto.ResultDto;
import com.ifanzero.mailreciever.service.SendResolver;

public class SendResolverImpl implements SendResolver {
    @Override
    public ResultDto sendToEC(EmployeeForTrans employee) {
       HttpRequest httpRequest =  HttpUtil.createPost("https://open.workec.com/customer/create");
        return null;
    }

    private boolean authorize(){
        HttpRequest httpRequest =  HttpUtil.createPost("https://open.workec.com/auth/accesstoken");

        return false;
    }





}
