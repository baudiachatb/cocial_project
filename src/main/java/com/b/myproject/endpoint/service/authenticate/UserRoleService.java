package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.entity.UserRoleEntity;
import java.util.List;

public interface UserRoleService {
    List<UserRoleEntity> findAllByUserId(String idUser);
    UserRoleEntity updateRoleUserByUserName(String userName, RoleType type);
    UserRoleEntity updateRoleUserByUserId(String userId, RoleType type);
}
