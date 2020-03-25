package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author: wangqisong
 * @date: 2019/9/6
 * @Description:
 */
@Controller
@RequestMapping(value = "/testPage")
public class TestPageController {
    @GetMapping(value = "/index2")
    public String returnPage(){
        return "index2";
    }
    @GetMapping(value = "/index22")
    @ResponseBody
    public String returnPage2(){
        return "index22";
    }
}
