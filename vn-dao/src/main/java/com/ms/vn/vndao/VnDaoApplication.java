package com.ms.vn.vndao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("com.ms.vn.vndao.mapper")
@ComponentScan(basePackages = {"com.ms.vn"})
public class VnDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnDaoApplication.class, args);
    }
}
