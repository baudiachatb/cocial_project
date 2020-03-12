package com.b.demosecurity.service.user;

import com.b.demosecurity.model.user.UserEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImpl implements UserServiceBasic {

    public Specification<UserEntity> hasId(String idUser){
        return (root, cq, cb) -> cb.equal(root.get("idUser"), idUser);
    }

    public Specification<UserEntity> hasUserName(String userName){
        return (root, cq, cb) -> cb.equal(root.get("userName"), userName);
    }
}
