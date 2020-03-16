package com.b.myproject.endpoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {
    @GetMapping("test1")
    public String test1(){
        return "here is test1";
    }

    @GetMapping("test2")
    public String test2(){
        return "here is test2";
    }
}
