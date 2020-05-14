package com.lustre.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MallAliCloudOssApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAliCloudOssApplication.class,args);
    }
}
