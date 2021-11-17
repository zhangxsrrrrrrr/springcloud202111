package edu.ahau.springcloud.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangxuna
 * @date 2021-11-16 22:06
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OpenfeignOrder80Main {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrder80Main.class);
    }
}
