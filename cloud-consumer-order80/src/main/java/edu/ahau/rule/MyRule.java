package edu.ahau.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2021-11-14 20:03
 */
@Configuration
public class MyRule {

    @Bean
    public IRule setRule(){
        return new RandomRule();
    }
}
