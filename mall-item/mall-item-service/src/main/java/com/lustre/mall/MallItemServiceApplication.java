package com.lustre.mall;

import com.lustre.mall.item.mapper.TbItemMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackageClasses = {TbItemMapper.class})
public class MallItemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallItemServiceApplication.class,args);
    }
}
