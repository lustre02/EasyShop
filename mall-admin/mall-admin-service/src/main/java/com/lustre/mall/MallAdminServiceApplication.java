package com.lustre.mall;

import com.lustre.mall.admin.mapper.TbAdminMapper;
import com.lustre.mall.admin.message.sink.TbAdminLoginLogSink;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackageClasses = {TbAdminMapper.class})
@EnableBinding({TbAdminLoginLogSink.class})
public class MallAdminServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallAdminServiceApplication.class, args);
    }
}
