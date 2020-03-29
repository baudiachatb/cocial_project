package com.b.myproject.endpoint.service.userdetailgoogle;

import com.b.myproject.endpoint.controller.payload.SearchParams;
import com.b.myproject.entity.UserDetailGoogleEntity;
import com.b.myproject.entity.UserDetailGoogleEntity_;
import com.b.myproject.repository.UserDetailGooleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailGooleServiceImpl implements IUserDetailGoogleService {
    private final UserDetailGooleRepo repo;

    @Override
    public Optional<UserDetailGoogleEntity> getById(String id) {
        return repo.findOne(Specification.where(hasId(id)));
    }

    @Override
    public UserDetailGoogleEntity getByEmail(String email) {
        return repo.findOne(Specification.where(hasEmail(email))).orElse(null);
    }

    @Override
    public UserDetailGoogleEntity createUser(UserDetailGoogleEntity entity) {
        entity.setCreateAt(Timestamp.from(new Date().toInstant()));
        entity.setUpdateAt(Timestamp.from(new Date().toInstant()));
        return repo.save(entity);
    }

    @Override
    public UserDetailGoogleEntity updateUser(UserDetailGoogleEntity entity) {
        return repo.save(entity);
    }

    @Override
    public List<UserDetailGoogleEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public List<UserDetailGoogleEntity> search(SearchParams searchParams) {
        return null;
    }

    private Specification<UserDetailGoogleEntity> hasEmail(String email) {
        return (root, cq, cb) -> cb.equal(root.get(UserDetailGoogleEntity_.email), email);
    }

    private Specification<UserDetailGoogleEntity> hasId(String id){
        return (root, cq, cb) -> cb.equal(root.get(UserDetailGoogleEntity_.id), id);
    }
}
