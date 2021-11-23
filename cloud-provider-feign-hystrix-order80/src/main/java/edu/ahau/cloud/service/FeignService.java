package edu.ahau.cloud.service;

import edu.ahau.cloud.service.fallback.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxuna
 * @date 2021-11-19 8:56
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = FeignServiceImpl.class)
public interface FeignService {
    @RequestMapping("/payment/timeOut/{id}")
    public String timeOutAction(@PathVariable("id") Integer id);

    @RequestMapping("/payment/ok/{id}")
    public String okAction(@PathVariable("id") Integer id);
}
