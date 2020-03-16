package com.b.myproject.repository;

import com.b.myproject.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, String>, JpaSpecificationExecutor<UserRoleEntity> {
}
