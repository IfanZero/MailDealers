package com.ifanzero.mailreciever.service;

import com.ifanzero.mailreciever.dao.dto.ResultDto;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53AllContent;
import com.ifanzero.mailreciever.dao.dto.cus_serv53.CusServ53RequestHeader;

public interface CusServ53Service {
    ResultDto saveChannal(CusServ53AllContent content);

    ResultDto saveBasic(CusServ53RequestHeader header);
}
