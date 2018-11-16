package com.ms.vn.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ms.vn"})
public class VnApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnApiApplication.class, args);
    }
}
