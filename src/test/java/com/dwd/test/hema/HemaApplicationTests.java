package com.dwd.test.hema;

import com.dwd.test.hema.domain.HemaBatchDTO;
import com.dwd.test.hema.mapper.HemaBatchMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HemaApplicationTests {
    @Autowired(required = false)
    HemaBatchMapper hemaBatchMapper;
    @Test
    public void contextLoads() {
        List<HemaBatchDTO> dtoList=hemaBatchMapper.getBatchIdByPlatformId("260");
        String batchId=dtoList.get(0).getBatchId();
        System.out.println("返回结果："+batchId);
    }

    }