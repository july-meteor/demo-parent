package com.meteor.demo.spring.security.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created  bhy on 2020/3/16
 **/
@RestController
//@RequestMapping("")
public class HomeController {

    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello ,spring security!";
    }
}
