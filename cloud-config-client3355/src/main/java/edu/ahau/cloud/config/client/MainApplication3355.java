package edu.ahau.cloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangxuna
 * @date 2021-11-25 22:17
 */
@EnableEurekaClient
@SpringBootApplication
public class MainApplication3355 {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication3355.class);
    }


}
