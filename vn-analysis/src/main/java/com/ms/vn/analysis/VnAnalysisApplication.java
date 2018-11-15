package com.ms.vn.analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ms.vn"})
public class VnAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(VnAnalysisApplication.class, args);
    }
}
