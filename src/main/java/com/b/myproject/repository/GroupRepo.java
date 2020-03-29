package com.b.myproject.repository;

import com.b.myproject.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<GroupEntity, String>, JpaSpecificationExecutor<GroupEntity> {
}
