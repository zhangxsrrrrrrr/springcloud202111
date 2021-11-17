package edu.ahau.springcloud.openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2021-11-16 23:05
 */
@Configuration
public class OpenfeignLogConfig {
    @Bean
    Logger.Level feignLog() {
        return Logger.Level.FULL;
    }
}
