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

import static com.b.myproject.common.MessageError.DANG_NHAP_THANH_CONG;


@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
public class UserController {
    private final ServiceComposite composite;

    @GetMapping("login")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String login() {
        return DANG_NHAP_THANH_CONG;
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
