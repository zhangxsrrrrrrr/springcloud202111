package edu.ahau.springcloud.controller;

import edu.ahau.cloud.entity.CommonResult;
import edu.ahau.springcloud.entity.Payment;
import edu.ahau.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int pay = paymentService.createPay(payment);
        if (pay > 0 ) {
            return new CommonResult<>(200, "插入成功");
        }
        return new CommonResult<>(400, "插入失败");
    }
    @GetMapping("/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById == null ) {
            System.out.println("jaha");
            return new CommonResult<>(400, "没查到");
        }
        return new CommonResult<Payment>(200, paymentById, port);
    }

    @GetMapping("/port")
    public String getPort(){
        return port;
    }

    @GetMapping("/feign/timeout")
    public String timeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
