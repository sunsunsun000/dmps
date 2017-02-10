package com.tanbobo.dmps;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.base.security.CustomFilterSecurityInterceptor;
import com.tanbobo.dmps.common.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = "com.tanbobo.dmps.mapper", markerInterface = BaseMapper.class)
@EnableAutoConfiguration(exclude = CustomFilterSecurityInterceptor.class) //注意
public class DmpsApplication {

    public static void main(String[] args) {
//        SpringApplication.run(DmpsApplication.class, args);
        ApplicationContext app = SpringApplication.run(DmpsApplication.class, args);
        SpringContextUtil.setApplicationContext(app);
    }
}
