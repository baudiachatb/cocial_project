package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.entity.RoleEntity;
import com.b.myproject.entity.RoleEntity_;
import com.b.myproject.repository.RoleRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {
    public static final String USER = "ROLE_USER";
    public static final String ADMIN = "ROLE_ADMIN";
    public static final String MASTER = "ROLE_MASTER";
    public static final String GUEST = "ROLE_GUEST";
    RoleRepo roleRepo;

    Specification<RoleEntity> hasIdRole(String idRole) {
        return (root, cq, cb) -> cb.equal(root.get(RoleEntity_.id), idRole);
    }

    Specification<RoleEntity> hasNameRole(String nameRole) {
        return (root, cq, cb) -> cb.equal(root.get(RoleEntity_.nameRole), nameRole);
    }

    @Override
    public RoleEntity getRoleByRoleName(String roleName) {
        return roleRepo.findOne(Specification.where(hasNameRole(roleName))).orElse(null);
    }
}
