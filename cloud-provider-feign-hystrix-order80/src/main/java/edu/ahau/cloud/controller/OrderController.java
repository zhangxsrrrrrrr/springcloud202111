package edu.ahau.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import edu.ahau.cloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhangxuna
 * @date 2021-11-09 13:12
 */
@RestController
@Slf4j
@RequestMapping("/payment")
//@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderController {

    @Resource
    private FeignService service;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/ok/{id}")
    public String okAction(@PathVariable("id") Integer id){
        return service.okAction(id);
    }

    @RequestMapping("/timeOut/{id}")
    public String timeOutAction(@PathVariable("id") Integer id){
//        try {
//            Thread.sleep(Long.parseLong("3000"));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return service.timeOutAction(id);
    }


    public String paymentInfo_TimeOut_Fallback(Integer integer){
        return "客户端展示异常"+ Thread.currentThread().getName();
    }


    public String globalFallbackMethod(){
        return "这是全局默认的fallback";
    }
}
