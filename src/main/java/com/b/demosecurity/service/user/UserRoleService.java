package com.b.demosecurity.service.user;

import com.b.demosecurity.common.constans.RoleType;
import com.b.demosecurity.model.user.RoleEntity;
import com.b.demosecurity.model.user.UserRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface UserRoleService {
    List<RoleEntity> getListRoleByIdUser(String idUser);
    UserRoleEntity save(String idUser, RoleType type);
}
