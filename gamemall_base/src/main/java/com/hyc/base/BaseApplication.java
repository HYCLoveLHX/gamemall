package com.hyc.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.SnowflakeIdWorker;

@SpringBootApplication
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class,args);
    }

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker(){
        return  new SnowflakeIdWorker(1,1);
    }
}
