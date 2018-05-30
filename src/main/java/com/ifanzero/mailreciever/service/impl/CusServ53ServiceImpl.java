package com.ifanzero.mailreciever.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ifanzero.mailreciever.dao.dto.ResultDto;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53AllContent;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53RequestHeader;
import com.ifanzero.mailreciever.dao.mapper.TCustInfo53Mapper;
import com.ifanzero.mailreciever.dao.model.TCustInfo53;
import com.ifanzero.mailreciever.service.CusServ53Service;
import com.ifanzero.mailreciever.util.RetCodeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional(readOnly =false)
public class CusServ53ServiceImpl implements CusServ53Service {
    @Resource
    private TCustInfo53Mapper tCustInfo53Mapper;
    @Override
    public ResultDto saveChannal(CusServ53AllContent content) {
        TCustInfo53 tCustInfo53 = new TCustInfo53();
        tCustInfo53.setGuestId(content.getSession().getGuest_id());

        String refererUrl = content.getSession().getReferer();
        if (StrUtil.isNotEmpty(refererUrl)){
            String paramStr = StrUtil.subAfter(refererUrl,"?",true);
            String[] params = StrUtil.split(paramStr,"&");
            for (String param:params){
                if (param.contains("utm_source")){
                    tCustInfo53.setReferer(StrUtil.subAfter(param,"=",true));
                }
            }
        }
        if (tCustInfo53Mapper.existsWithPrimaryKey(tCustInfo53)){
            tCustInfo53Mapper.updateByPrimaryKeySelective(tCustInfo53);
        }else {
            tCustInfo53Mapper.insert(tCustInfo53);
        }
        ResultDto resultDto = new ResultDto();
        resultDto.setResultCode(RetCodeUtils.SUCCESS);
        resultDto.setResultInfo(RetCodeUtils.SUCCESS_INFO);
        return resultDto;
    }

    @Override
    public ResultDto saveBasic(CusServ53RequestHeader header) {
        TCustInfo53 tCustInfo53 = new TCustInfo53();
        tCustInfo53.setGuestId(header.getGuest_id());

        tCustInfo53.setGuestName(header.getGuest_name());
        tCustInfo53.setPhone(header.getMobile());
        tCustInfo53.setEmail(header.getEmail());
        tCustInfo53.setProvince(header.getProvince());
        tCustInfo53.setCity(header.getCity());
        /**
         * @TODO 需要确认notes字段来自哪里
         */
        tCustInfo53.setNotes("");
        if (tCustInfo53Mapper.existsWithPrimaryKey(tCustInfo53)){
            tCustInfo53Mapper.updateByPrimaryKeySelective(tCustInfo53);
        }else {
            tCustInfo53Mapper.insert(tCustInfo53);
        }
        ResultDto resultDto = new ResultDto();
        resultDto.setResultCode(RetCodeUtils.SUCCESS);
        resultDto.setResultInfo(RetCodeUtils.SUCCESS_INFO);
        return resultDto;
    }
}
