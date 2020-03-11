package com.b.demosecurity;

import com.b.demosecurity.model.user.User;
import com.b.demosecurity.repository.user.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.sql.Timestamp;

@SpringBootApplication
public class DemosecurityApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemosecurityApplication.class, args);
//        User user = new User("bau", "nguyen", "demo@gmail.com", "baudiachatb", "1234", null,null,null, 1);
//        UserRepo userRepo = context.getBean(UserRepo.class);
//        userRepo.save(user);
    }

}
