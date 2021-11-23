package edu.ahau.springcloud.controller;

import edu.ahau.cloud.entity.CommonResult;
import edu.ahau.springcloud.entity.Payment;
import edu.ahau.springcloud.service.PaymentService;
import edu.ahau.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxuna
 * @date 2021-11-09 13:12
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PayController {

    @Resource
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/ok/{id}")
    public String okAction(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_Ok(id) +"\t 端口号"+ serverPort;
    }

    @RequestMapping("/timeOut/{id}")
    public String timeOutAction(@PathVariable("id") Integer id) throws InterruptedException {
        return paymentService.paymentInfo_TimeOut(id) +"\t 端口号"+ serverPort;
    }

    @RequestMapping("/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) throws InterruptedException {
        return paymentService.paymentCircuitBreaker(id) +"\t 端口号"+ serverPort;
    }
}
