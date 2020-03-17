package com.b.myproject;

import com.b.myproject.endpoint.service.authenticate.AuthenticationServiceComposite;
import com.b.myproject.endpoint.service.authenticate.RoleService;
import com.b.myproject.endpoint.service.authenticate.RoleServiceImpl;
import com.b.myproject.endpoint.service.authenticate.UserRoleService;
import com.b.myproject.entity.RoleEntity;
import com.b.myproject.entity.UserEntity;
import com.b.myproject.repository.RoleRepo;
import com.b.myproject.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.sql.Timestamp;

@SpringBootApplication
public class MyprojectApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MyprojectApplication.class, args);
//        SecurityContextHolder securityContextHolder = context.getBean(SecurityContextHolder.M);
//        UserEntity userEntity = context.getBean(UserEntity.class);
        AuthenticationServiceComposite authenticationServiceComposite = context.getBean(AuthenticationServiceComposite.class);
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        UserRepo userRepo = context.getBean(UserRepo.class);
        RoleRepo roleRepo = context.getBean(RoleRepo.class);
        RoleService roleService = context.getBean(RoleService.class);
        String password = passwordEncoder.encode("1234");
//        for(int i = 1; i<5; i++){
//            UserEntity user = UserEntity.builder()
//                    .username("test"+(i+1))
//                    .firstName("demo")
//                    .lastName("1")
//                    .password(password)
//                    .email("abc"+i+"@gmail.com")
//                    .enable(Byte.parseByte("1"))
//                    .build();
//            authenticationServiceComposite.userService.createUser(user);
//        }
//        roleRepo.save(RoleEntity.builder()
//                .nameRole(RoleServiceImpl.GUEST)
//                .enable(Byte.parseByte("1"))
//                .build());
    }

}
