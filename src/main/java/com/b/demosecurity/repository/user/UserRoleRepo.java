package com.b.demosecurity.repository.user;

import com.b.demosecurity.model.user.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, String>, JpaSpecificationExecutor {
    public List<UserRoleEntity> findAllByUserByIdUser(String idUser);
}
