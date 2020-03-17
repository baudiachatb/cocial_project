package com.b.myproject.repository;

import com.b.myproject.entity.UserEntity;
import com.b.myproject.entity.UserRoleEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, String>, JpaSpecificationExecutor<UserRoleEntity> {
    List<UserRoleEntity> findAllByUserByIdUser(UserEntity userEntity);
}
