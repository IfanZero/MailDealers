package com.ifanzero.mailreciever.service;

import com.ifanzero.mailreciever.dao.domain.EmployeeForTrans;

public interface AnalyzeContent {

    EmployeeForTrans analyze51Mail(String content);

    EmployeeForTrans analyze58Mail(String content);

    EmployeeForTrans analyzeZhaoPinMail(String content);

    EmployeeForTrans LoadCusServ53Info(String content);

}
