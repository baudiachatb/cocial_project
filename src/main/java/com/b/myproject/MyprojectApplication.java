package com.b.myproject;

import com.b.myproject.entity.UserEntity;
import com.b.myproject.entity.UserEntity_;
import com.b.myproject.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyprojectApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MyprojectApplication.class, args);
////        UserEntity userEntity = context.getBean(UserEntity.class);
//        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
//        UserRepo userRepo = context.getBean(UserRepo.class);
//        for(int i = 1; i<5; i++){
//            UserEntity user = UserEntity.builder()
//                    .username("test"+i)
//                    .password(passwordEncoder.encode("1234"))
//                    .email("abc"+i+"@gmail.com")
//                    .enable(Byte.parseByte("1"))
//                    .build();
//        }
    }

}
