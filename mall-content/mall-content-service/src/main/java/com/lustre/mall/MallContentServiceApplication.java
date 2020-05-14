package com.lustre.mall;

import com.lustre.mall.content.mapper.TbContentMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackageClasses = {TbContentMapper.class})
public class MallContentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallContentServiceApplication.class,args);
    }
}
