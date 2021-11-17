package edu.ahau.cloud;

import com.netflix.loadbalancer.RoundRobinRule;
import edu.ahau.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zhangxuna
 * @date 2021-11-09 22:33
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(value="CLOUD-PAYMENT-SERVICE", configuration = RoundRobinRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
