package com.ms.vn.acquisition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ms.vn"})
public class VnAcquisitionApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnAcquisitionApplication.class, args);
    }
}
