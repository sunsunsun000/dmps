package com.tanbobo.dmps;

import com.tanbobo.dmps.base.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tanbobo.dmps.mapper", markerInterface = BaseMapper.class)
public class DmpsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmpsApplication.class, args);
    }
}
