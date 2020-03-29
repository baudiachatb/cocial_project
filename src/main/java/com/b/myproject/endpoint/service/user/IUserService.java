package com.b.myproject.endpoint.service.user;

import com.b.myproject.entity.UserEntity;

public interface IUserService {
    UserEntity findUserByUserName(String userName);
    UserEntity findUserByUserId(String userId);
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
    void deleteUser(String idUser);
}
