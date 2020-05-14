package com.lustre.mall;

import com.lustre.mall.core.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import({RedisConfig.class})
public class MallItemControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallItemControllerApplication.class,args);
    }
}
