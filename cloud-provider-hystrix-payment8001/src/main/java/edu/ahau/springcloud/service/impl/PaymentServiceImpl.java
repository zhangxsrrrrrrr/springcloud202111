package edu.ahau.springcloud.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangxuna
 * @date 2021-11-09 13:11
 */
@Service
public class PaymentServiceImpl {
    /**
     * -   程序运行异常
     * -   超时
     * -   服务熔断触发服务降级
     * -   线程池/信号量打满也会导致服务降级
     **/
    public String paymentInfo_Ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_ok,id：" + id + "\t" + "O(∩_∩)O";
    }

    // 线程隔离
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentInfo_TimeOut(Integer id) throws InterruptedException {

        TimeUnit.SECONDS.sleep(3);

        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id：" + id + "\t" + "消耗3秒";
    }

    public String paymentInfo_TimeOut_Fallback(Integer integer) {
        return "呵呵，已经超时或者报错了都" + Thread.currentThread().getName();
    }


    // ******************服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
            commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "70")})
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("====id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，流水号" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Integer id) {
        return "id 不能为负数，请稍后再试    id：" + id;
    }

}
