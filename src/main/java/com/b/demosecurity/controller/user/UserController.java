package com.b.demosecurity.controller.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {
    @GetMapping("demo1")
    @PreAuthorize("USER")
    public String demo1(){
        return "there are demo1";
    }

    @GetMapping("demo2")
    public String demo2(){
        return "there are demo2";
    }
}
