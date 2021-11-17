package edu.ahau.cloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangxuna
 * @date 2021-11-13 10:31
 */
@SpringBootApplication
// 该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class Payment8004Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004Main.class);
    }
}
