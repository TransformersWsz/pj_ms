package com.bosch.pj_ms.service.impl;

import com.bosch.pj_ms.mapper.LogMapper;
import com.bosch.pj_ms.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public Integer addLogService(String operation) {
        return logMapper.insertLog(operation);
    }
}
