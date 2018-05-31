package com.ifanzero.mailreciever.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ifanzero.mailreciever.dao.dto.ResultDto;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53AllContent;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53RequestHeader;
import com.ifanzero.mailreciever.dao.mapper.TCustInfoMapper;
import com.ifanzero.mailreciever.dao.model.TCustInfo;
import com.ifanzero.mailreciever.service.CusServ53Service;
import com.ifanzero.mailreciever.util.RetCodeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional(readOnly =false)
public class CusServ53ServiceImpl implements CusServ53Service {
    @Resource
    private TCustInfoMapper tCustInfoMapper;
    @Override
    public ResultDto saveChannal(CusServ53AllContent content) {
        TCustInfo tCustInfo = new TCustInfo();
        tCustInfo.setGuestId(content.getSession().getGuest_id());

        String refererUrl = content.getSession().getReferer();
        if (StrUtil.isNotEmpty(refererUrl)){
            String paramStr = StrUtil.subAfter(refererUrl,"?",true);
            String[] params = StrUtil.split(paramStr,"&");
            for (String param:params){
                if (param.contains("utm_source")){
                    tCustInfo.setReferer(StrUtil.subAfter(param,"=",true));
                }
            }
        }
        if (tCustInfoMapper.existsWithPrimaryKey(tCustInfo)){
            tCustInfoMapper.updateByPrimaryKeySelective(tCustInfo);
        }else {
            tCustInfoMapper.insert(tCustInfo);
        }
        ResultDto resultDto = new ResultDto();
        resultDto.setResultCode(RetCodeUtils.SUCCESS);
        resultDto.setResultInfo(RetCodeUtils.SUCCESS_INFO);
        return resultDto;
    }

    @Override
    public ResultDto saveBasic(CusServ53RequestHeader header) {
        TCustInfo tCustInfo = new TCustInfo();
        tCustInfo.setGuestId(header.getGuest_id());

        tCustInfo.setGuestName(header.getGuest_name());
        tCustInfo.setPhone(header.getMobile());
        tCustInfo.setEmail(header.getEmail());
        tCustInfo.setProvince(header.getProvince());
        tCustInfo.setCity(header.getCity());
        /**
         * @TODO 需要确认notes字段来自哪里
         */
        tCustInfo.setNotes("");
        if (tCustInfoMapper.existsWithPrimaryKey(tCustInfo)){
            tCustInfoMapper.updateByPrimaryKeySelective(tCustInfo);
        }else {
            tCustInfoMapper.insert(tCustInfo);
        }
        ResultDto resultDto = new ResultDto();
        resultDto.setResultCode(RetCodeUtils.SUCCESS);
        resultDto.setResultInfo(RetCodeUtils.SUCCESS_INFO);
        return resultDto;
    }
}
