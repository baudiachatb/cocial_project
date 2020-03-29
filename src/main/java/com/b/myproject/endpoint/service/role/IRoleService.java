package com.b.myproject.endpoint.service.role;

import com.b.myproject.entity.RoleEntity;

public interface IRoleService {
    RoleEntity getRoleByRoleName(String roleName);
}
