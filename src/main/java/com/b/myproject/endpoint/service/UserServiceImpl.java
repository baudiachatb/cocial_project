package com.b.myproject.endpoint.service;

import com.b.myproject.entity.UserEntity;
import com.b.myproject.entity.UserEntity_;
import com.b.myproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public UserEntity findUserByUserName(String userName) {
            return userRepo.findOne(Specification.where(hasUserName(userName))).orElse(null);
    }

    private Specification<UserEntity> hasUserName(String userName) {
        return (root, cq, cb) -> cb.equal(root.get(UserEntity_.username), userName);
    }
}
