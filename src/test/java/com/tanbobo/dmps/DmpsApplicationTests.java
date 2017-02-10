package com.tanbobo.dmps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DmpsApplicationTests {

    @Test
    public void contextLoads() {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);//将密码加密 可以先设置初始密码：000000
        // 使用密码为key值进行加密，会自动加密密码
        System.out.println("密码" + bc.encode("1qaz2wsx"));
    }

}
