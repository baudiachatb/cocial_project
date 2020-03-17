package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.entity.RoleEntity;

public interface RoleService {
    RoleEntity getRoleByRoleName(String roleName);
}
