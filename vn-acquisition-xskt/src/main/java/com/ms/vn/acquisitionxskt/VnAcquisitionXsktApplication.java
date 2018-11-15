package com.ms.vn.acquisitionxskt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ms.vn"})
public class VnAcquisitionXsktApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnAcquisitionXsktApplication.class, args);
    }
}
