package com.b.myproject.repository;

import com.b.myproject.entity.UserDetailGoogleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailGooleRepo extends JpaRepository<UserDetailGoogleEntity, String>, JpaSpecificationExecutor<UserDetailGoogleEntity> {
}
