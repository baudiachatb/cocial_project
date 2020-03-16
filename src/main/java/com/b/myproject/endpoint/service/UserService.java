package com.b.myproject.endpoint.service;

import com.b.myproject.entity.UserEntity;

public interface UserService {
    UserEntity findUserByUserName(String userName);
}
