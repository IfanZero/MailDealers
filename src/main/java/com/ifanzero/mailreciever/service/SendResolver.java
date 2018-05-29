package com.ifanzero.mailreciever.service;

import com.ifanzero.mailreciever.dao.domain.EmployeeForTrans;
import com.ifanzero.mailreciever.dao.dto.ResultDto;

public interface SendResolver {
    ResultDto sendToEC(EmployeeForTrans employee);
}
