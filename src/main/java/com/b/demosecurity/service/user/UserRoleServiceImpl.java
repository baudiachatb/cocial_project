package com.b.demosecurity.service.user;

import com.b.demosecurity.common.constans.RoleType;
import com.b.demosecurity.model.user.RoleEntity;
import com.b.demosecurity.model.user.UserRoleEntity;
import com.b.demosecurity.model.user.UserRoleEntity_;
import com.b.demosecurity.repository.user.UserRoleRepo;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Data
public class UserRoleServiceImpl implements UserRoleService {
    UserRoleRepo userRoleRepo;
    public Specification hasIdUser(String idUser){
        return (root, cq, cb) -> cb.equal(root.get(UserRoleEntity_.USER_BY_ID_USER), idUser);
    }

    public Specification hasIdRole(String idRole){
        return (root, cq, cb) -> cb.equal(root.get(UserRoleEntity_.ROLE_BY_ID_ROLE), idRole);
    }

    public Specification hasidUserRole(String idUserRole){
        return (root, cq, cb) -> cb.equal(root.get(UserRoleEntity_.ID_USER_ROLE), idUserRole);
    }

    @Override
    public List<RoleEntity> getListRoleByIdUser(String idUser) {
        return userRoleRepo.findAllByUserByIdUser(idUser).stream().map(UserRoleEntity::getRoleByIdRole).collect(Collectors.toList());
    }

    @Override
    public UserRoleEntity save(String idUser, RoleType type) {
        return null;
    }
}
