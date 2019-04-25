package com.dwd.test.hema.service;

import com.dwd.test.hema.domain.HemaBatchDTO;
import com.dwd.test.hema.mapper.HemaBatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

import java.util.List;
@Component
public class GetHemaBatchService {
    @Autowired
    HemaBatchMapper hemaBatchMapper;
    public String getHemaBatch()
    {
        String batchId;
        List<HemaBatchDTO> dtoList=hemaBatchMapper.getBatchIdByPlatformId("260");
        if (dtoList.size()>0) {
            batchId = dtoList.get(0).getBatchId();
        }else {batchId="没有可用批次";}
        return batchId;
    }
}