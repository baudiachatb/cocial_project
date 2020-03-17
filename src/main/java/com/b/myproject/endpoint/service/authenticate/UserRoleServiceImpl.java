package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.entity.UserRoleEntity;
import com.b.myproject.entity.UserRoleEntity_;
import com.b.myproject.repository.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepo userRoleRepo;
    @Override
    public List<UserRoleEntity> findAllByUserId(String idUser) {
        return userRoleRepo.findAll(hasUserId(idUser));
    }

    private Specification<UserRoleEntity> hasUserId(String idUser){
        return (root, cq, cb) -> cb.equal(root.get(UserRoleEntity_.userByIdUser), idUser);
    }
}
