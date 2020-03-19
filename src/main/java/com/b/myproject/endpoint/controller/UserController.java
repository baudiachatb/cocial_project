package com.b.myproject.endpoint.controller;

import com.b.myproject.endpoint.service.authenticate.AuthenticationServiceComposite;
import com.b.myproject.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
public class UserController {
    AuthenticationServiceComposite composite;
    @GetMapping("test1")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String test1(){
        return "here is test1";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyRole('USER')")
    public String test2(){
        return "here is test2";
    }

    @GetMapping("/${username}")
    public UserEntity getUserByUserName(@PathVariable("username") String userName){
        return composite.userService.findUserByUserName(userName);
    }

}
