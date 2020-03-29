package com.b.myproject;

import com.b.myproject.endpoint.service.ServiceComposite;
import com.b.myproject.endpoint.service.role.IRoleService;
import com.b.myproject.endpoint.service.role.RoleServiceImpl;
import com.b.myproject.entity.UserEntity;
import com.b.myproject.repository.RoleRepo;
import com.b.myproject.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyprojectApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MyprojectApplication.class, args);
//        SecurityContextHolder securityContextHolder = context.getBean(SecurityContextHolder.M);
//        UserEntity userEntity = context.getBean(UserEntity.class);
        ServiceComposite serviceComposite = context.getBean(ServiceComposite.class);
        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        UserRepo userRepo = context.getBean(UserRepo.class);
        RoleRepo roleRepo = context.getBean(RoleRepo.class);
        IRoleService roleService = context.getBean(RoleServiceImpl.class);
//        for(int i = 2; i<5; i++){
//            UserEntity user = UserEntity.builder()
//                    .username("testdemo"+(i+1))
//                    .firstName("demo")
//                    .lastName("1")
//                    .password("1234")
//                    .email("abc"+i+"@gmail.com")
//                    .enable(Byte.parseByte("1"))
//                    .build();
//            serviceComposite.userService.createUser(user);
//        }
//        roleRepo.save(RoleEntity.builder()
//                .nameRole(RoleServiceImpl.ADMIN)
//                .enable(Byte.parseByte("1"))
//                .build());
    }

}
