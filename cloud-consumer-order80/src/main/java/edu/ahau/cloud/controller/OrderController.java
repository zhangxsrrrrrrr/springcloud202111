package edu.ahau.cloud.controller;

import edu.ahau.cloud.entity.CommonResult;
import edu.ahau.cloud.entity.Payment;
import edu.ahau.cloud.lb.LoadBalancer;
import edu.ahau.cloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-09 22:21
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private LoadBalancer myLB;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private static final String url = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(url+"/payment/get/"+id, CommonResult.class);
    }
    @PostMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        return restTemplate.postForObject(url+"/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            log.error("没有服务实例");
        }
        ServiceInstance instance = myLB.instances(instances);
        URI uri = instance.getUri();
        log.info(String.valueOf(uri));
        return restTemplate.getForObject(uri.toString()+"/payment/port", String.class);
    }


}
