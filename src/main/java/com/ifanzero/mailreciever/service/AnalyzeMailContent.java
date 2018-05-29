package com.ifanzero.mailreciever.service;

import com.ifanzero.mailreciever.dao.domain.EmployeeForTrans;

public interface AnalyzeMailContent {

    EmployeeForTrans analyze51Mail(String content);

    EmployeeForTrans analyze58Mail(String content);

    EmployeeForTrans analyzeZhaoPinMail(String content);
}
