package com.b.myproject.endpoint.controller;

import com.b.myproject.endpoint.service.ServiceComposite;
import com.b.myproject.entity.UserDetailGoogleEntity;
import com.b.myproject.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
public class UserController {
    private final ServiceComposite composite;

    @GetMapping("test1")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String test1() {
        return "here is test1";
    }

    @GetMapping("test2")
    @PreAuthorize("hasAnyRole('USER')")
    public String test2() {
        return "here is test2";
    }

    @GetMapping("/get")
    public UserEntity getUserByUserName(@RequestParam("username") String userName) {
        return composite.userService.findUserByUserName(userName);
    }

    @PostMapping("login/google")
    public UserDetailGoogleEntity loginByGoogle(@RequestBody @Valid UserDetailGoogleEntity userGooole) {
        Optional<UserDetailGoogleEntity> userDetailGoogleEntity = composite.userDetailGoogleService.getById(userGooole.getId());
        return userDetailGoogleEntity.orElseGet(() -> composite.userDetailGoogleService.createUser(userGooole));
    }
    @PostMapping("signup/google")
    public UserEntity signupWithGoogle(@RequestBody @Valid UserEntity entity){
        return composite.userService.createUser(entity);
    }

}
