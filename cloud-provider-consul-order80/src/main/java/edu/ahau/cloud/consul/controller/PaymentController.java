package edu.ahau.cloud.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author zhangxuna
 * @date 2021-11-13 10:33
 */
@RestController
@RequestMapping("/order")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @Autowired
    private  RestTemplate restTemplate;

    private final static String url = "http://provider-payment-consul";


    @RequestMapping(value = "/port")
    public String getPort(){
        return UUID.randomUUID()+"----------->"+port;
    }

    @RequestMapping(value = "/remote")
    public String remote(){
        return UUID.randomUUID()+"----------->"+restTemplate.getForObject(url+"/payment/port", String.class);
    }
}
