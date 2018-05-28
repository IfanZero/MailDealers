package com.ifanzero.mailreciever.service;

import com.ifanzero.mailreciever.dao.dto.Employee;

public interface AnalyzeMailContent {

    Employee analyze51Mail(String content);
}
