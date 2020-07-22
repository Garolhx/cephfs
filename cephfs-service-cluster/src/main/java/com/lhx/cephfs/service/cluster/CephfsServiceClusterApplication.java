package com.lhx.cephfs.service.cluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.lhx.cephfs.commons.mapper")
public class CephfsServiceClusterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CephfsServiceClusterApplication.class, args);
    }
}
