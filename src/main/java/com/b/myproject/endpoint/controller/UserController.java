package com.b.myproject.endpoint.controller;

import com.b.myproject.endpoint.statemanager.UserState;
import com.b.myproject.entity.UserEntity;
import com.b.myproject.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    UserRepo userRepo;
    UserState userState;
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

    @PostMapping("/sigup")
    public UserEntity create(@RequestBody UserEntity user){
        UserEntity result = userRepo.save(user);
        if(result != null){
            userState.sendUpdateUser(result.getId());

        }
        return result;
    }
}
