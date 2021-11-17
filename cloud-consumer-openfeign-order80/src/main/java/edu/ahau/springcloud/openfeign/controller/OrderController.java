package edu.ahau.springcloud.openfeign.controller;

import edu.ahau.cloud.entity.CommonResult;
import edu.ahau.springcloud.openfeign.entity.Payment;
import edu.ahau.springcloud.openfeign.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxuna
 * @date 2021-11-16 22:14
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable Integer id) {
        System.out.println(" --------" + paymentFeignService);
        return paymentFeignService.get(id);
    }

    @GetMapping("/payment/feign/timeout")
    public String timeOut() {
        return paymentFeignService.timeOut();
    }

    public static void main(String[] args) {
        String requestURI = "/uop/yys/v1/cust/downUtil?clientFile=44433&23.txt&remoteFile=202111171637117002419.txt";
        requestURI = requestURI.substring(requestURI.indexOf("?") + 1);
        requestURI = requestURI.replace("/uop/yys/v1/cust/downUtil?","");
        int lastIndexOf = requestURI.lastIndexOf("&");
        String clientFile = requestURI.replace("clientFile=","").substring(0,lastIndexOf-"remoteFile=".length());
        String remoteFile = requestURI.substring(lastIndexOf + "remoteFile=".length() + 1);
        System.out.println(clientFile);
        System.out.println(remoteFile);
    }
}
