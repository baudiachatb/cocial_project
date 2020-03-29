package com.b.myproject.endpoint.service.userdetailgoogle;

import com.b.myproject.endpoint.controller.payload.SearchParams;
import com.b.myproject.entity.UserDetailGoogleEntity;
import java.util.List;
import java.util.Optional;

public interface IUserDetailGoogleService {
    Optional<UserDetailGoogleEntity> getById(String id);
    UserDetailGoogleEntity getByEmail(String email);
    UserDetailGoogleEntity createUser(UserDetailGoogleEntity entity);
    UserDetailGoogleEntity updateUser(UserDetailGoogleEntity entity);
    List<UserDetailGoogleEntity> getAll();
    List<UserDetailGoogleEntity> search(SearchParams searchParams);
}
