package com.dwd.test.hema;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dwd.test.hema.mapper")
@SpringBootApplication
public class HemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HemaApplication.class, args);
    }

}
