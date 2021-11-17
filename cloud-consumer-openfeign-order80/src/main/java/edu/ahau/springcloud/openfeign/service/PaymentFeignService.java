package edu.ahau.springcloud.openfeign.service;

import edu.ahau.cloud.entity.CommonResult;
import edu.ahau.springcloud.openfeign.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxuna
 * @date 2021-11-16 22:08
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Integer id);

    @GetMapping("/payment/feign/timeout")
    public String timeOut();
}
