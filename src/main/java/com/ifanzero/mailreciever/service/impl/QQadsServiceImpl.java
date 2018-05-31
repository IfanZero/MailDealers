package com.ifanzero.mailreciever.service.impl;

import com.ifanzero.mailreciever.dao.dto.ResultDto;
import com.ifanzero.mailreciever.dao.dto.qq_ads.QQadsRequest;
import com.ifanzero.mailreciever.dao.mapper.TCustInfoMapper;
import com.ifanzero.mailreciever.dao.model.TCustInfo;
import com.ifanzero.mailreciever.service.QQadsService;
import com.ifanzero.mailreciever.util.RetCodeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class QQadsServiceImpl implements QQadsService {
    @Resource
    private TCustInfoMapper tCustInfoMapper;
    @Override
    public ResultDto saveAds(QQadsRequest content) {
        TCustInfo custInfo = new TCustInfo();
        List<QQadsRequest.DataBeanX.DataBean> datas=content.getData().getData();
        String label= "";
        StringBuilder sb = new StringBuilder();
        for (QQadsRequest.DataBeanX.DataBean data:datas){
            label = data.getLabel();
            if ("您的姓名".equals(label)){
                custInfo.setGuestName(data.getValue());
            }
            else if ("您的电话".equals(label)){
                custInfo.setPhone(data.getValue());
            }else {
                sb.append(label).append(":").append(data.getValue()).append("; ");
            }
        }
        if (tCustInfoMapper.existsWithPrimaryKey(custInfo)){
            tCustInfoMapper.updateByPrimaryKeySelective(custInfo);
        }else {
            tCustInfoMapper.insert(custInfo);
        }
        custInfo.setNotes(sb.toString().substring(0,450));
        ResultDto resultDto = new ResultDto();
        resultDto.setResultCode(RetCodeUtils.SUCCESS);
        resultDto.setResultInfo(RetCodeUtils.SUCCESS_INFO);
        return resultDto;
    }
}
