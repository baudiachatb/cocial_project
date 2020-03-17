package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.entity.UserEntity;

public interface UserService {
    UserEntity findUserByUserName(String userName);
    UserEntity createUser(UserEntity userEntity) throws Exception;
    UserEntity updateUser(UserEntity userEntity) throws Exception;
}
