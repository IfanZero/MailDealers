package com.ifanzero.mailreciever.dao.mapper;

import com.ifanzero.mailreciever.dao.MyMapper;
import com.ifanzero.mailreciever.dao.model.TCustInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface TCustInfoMapper extends MyMapper<TCustInfo> {
}