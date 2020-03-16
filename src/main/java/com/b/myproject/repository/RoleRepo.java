package com.b.myproject.repository;

import com.b.myproject.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, String>, JpaSpecificationExecutor<RoleEntity> {
}
