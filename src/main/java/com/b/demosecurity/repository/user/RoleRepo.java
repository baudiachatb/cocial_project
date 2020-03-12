package com.b.demosecurity.repository.user;

import com.b.demosecurity.model.user.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, String>, JpaSpecificationExecutor {
}
