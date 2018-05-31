package com.ifanzero.mailreciever.service;

import com.ifanzero.mailreciever.dao.dto.ResultDto;
import com.ifanzero.mailreciever.dao.dto.qq_ads.QQadsRequest;

public interface QQadsService {
    ResultDto saveAds(QQadsRequest content);
}
