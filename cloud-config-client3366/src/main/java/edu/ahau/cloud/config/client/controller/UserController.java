package edu.ahau.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxuna
 * @date 2021-11-25 22:51
 */
@RestController
@RefreshScope
public class UserController {
    @Value("${content.info}")
    private String name;

    @RequestMapping("/config")
    public String config(){
        return name;
    }
}
