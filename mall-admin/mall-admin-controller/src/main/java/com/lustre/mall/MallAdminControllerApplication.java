package com.lustre.mall;

import com.lustre.mall.admin.message.source.TbAdminLoginLogSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({TbAdminLoginLogSource.class})
public class MallAdminControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAdminControllerApplication.class,args);
    }
}
