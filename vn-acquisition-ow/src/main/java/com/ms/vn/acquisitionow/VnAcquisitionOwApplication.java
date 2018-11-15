package com.ms.vn.acquisitionow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ms.vn"})
public class VnAcquisitionOwApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnAcquisitionOwApplication.class, args);
    }
}
