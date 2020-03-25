package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wangqisong
 * @date: 2019/9/3
 * @Description:
 */
@RestController
@RequestMapping("/demo")
public class TestController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello world";
    }

}
