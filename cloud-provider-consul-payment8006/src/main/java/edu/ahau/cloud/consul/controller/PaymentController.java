package edu.ahau.cloud.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhangxuna
 * @date 2021-11-13 10:33
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/port")
    public String getPort(){
        return UUID.randomUUID()+"----------->"+port;
    }
}
