package com.b.demosecurity.controller.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
public class UserController {
    @GetMapping("demo1")
    public String demo1(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "there are demo1";
    }

    @GetMapping("demo2")
    public String demo2(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "there are demo2";
    }
}
