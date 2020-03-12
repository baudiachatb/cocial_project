package com.b.demosecurity;

import com.b.demosecurity.model.user.UserEntity;
import com.b.demosecurity.repository.user.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class DemosecurityApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemosecurityApplication.class, args);
        UserRepo userRepo = context.getBean(UserRepo.class);
        for(int i = 0; i< 5; i++){
            userRepo.save(
                    UserEntity.builder()
                            .firstName("abc")
                            .lastName("123")
                            .username("test"+i)
                            .password("1234")
                            .email("test"+i+"@gmail.com")
                            .createAt(new Timestamp(new Date().getTime()))
                            .updateAt(new Timestamp(new Date().getTime())).enable(Byte.parseByte("1"))
                            .build()
            );
        }
    }

}
