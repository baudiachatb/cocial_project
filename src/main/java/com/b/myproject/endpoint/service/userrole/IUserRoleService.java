package com.b.myproject.endpoint.service.userrole;

import com.b.myproject.endpoint.service.role.RoleType;
import com.b.myproject.entity.UserRoleEntity;

import java.util.List;

public interface IUserRoleService {
    List<UserRoleEntity> findAllByUserId(String idUser);
    UserRoleEntity updateRoleUserByUserName(String userName, RoleType type);
    UserRoleEntity updateRoleUserByUserId(String userId, RoleType type);
}
