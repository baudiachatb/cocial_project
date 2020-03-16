package com.b.myproject.endpoint.service;

import com.b.myproject.entity.UserRoleEntity;
import java.util.List;

public interface UserRoleService {
    List<UserRoleEntity> findAllByUserId(String idUser);
}
