package com.dwd.test.hema.controller;

import com.dwd.test.hema.service.GetHemaBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetHemaBatchController {
    @Autowired
    GetHemaBatchService getHemaBatchService;
    @RequestMapping("/")
    public String getHemaBatch()
    {
        String batchId=getHemaBatchService.getHemaBatch();
        return batchId;
    }
}
