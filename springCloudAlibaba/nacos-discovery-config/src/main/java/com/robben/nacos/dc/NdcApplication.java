package com.robben.nacos.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
public class NdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(NdcApplication.class, args);
    }

}