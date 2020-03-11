package com.b.demosecurity.repository.user;

import com.b.demosecurity.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String>, JpaSpecificationExecutor {
}
