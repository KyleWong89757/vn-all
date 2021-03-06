package com.ms.vn.vnservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ms.vn"})
public class VnServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnServiceApplication.class, args);
    }
}
