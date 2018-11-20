package com.ms.vn.quartz.init;

import org.quartz.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JobConfig {
    @Bean
    public Map<String, Job> getJobMap(){
        return new HashMap<String, Job>();
    }
}
