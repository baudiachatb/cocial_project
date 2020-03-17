package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.entity.UserEntity;

public interface UserService {
    UserEntity findUserByUserName(String userName);
    UserEntity findUserByUserId(String userId);
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
}
