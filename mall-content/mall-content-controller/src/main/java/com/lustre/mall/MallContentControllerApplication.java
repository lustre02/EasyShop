package com.lustre.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MallContentControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallContentControllerApplication.class,args);
    }
}
