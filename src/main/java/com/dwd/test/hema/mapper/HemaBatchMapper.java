package com.dwd.test.hema.mapper;

import com.dwd.test.hema.domain.HemaBatchDTO;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface HemaBatchMapper {
    List<HemaBatchDTO> getBatchIdByPlatformId(String platformId);
}
