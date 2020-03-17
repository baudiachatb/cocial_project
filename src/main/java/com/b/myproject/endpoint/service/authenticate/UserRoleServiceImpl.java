package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.endpoint.statemanager.UserStateService;
import com.b.myproject.entity.RoleEntity;
import com.b.myproject.entity.UserEntity;
import com.b.myproject.entity.UserRoleEntity;
import com.b.myproject.entity.UserRoleEntity_;
import com.b.myproject.repository.UserRoleRepo;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;
    private final UserStateService userStateService;
    private final UserService userService;
    private final RoleService roleService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @PostConstruct
    void init() {
        Disposable disposable1 = userStateService.updateUserAsObs().subscribe(this::setRoleDefault);
        compositeDisposable.add(disposable1);
    }

    @Override
    public List<UserRoleEntity> findAllByUserId(String idUser) {
        UserEntity userEntity = userService.findUserByUserId(idUser);
        return userRoleRepo.findAll(hasUserId(userEntity));
    }

    @Override
    public UserRoleEntity updateRoleUserByUserName(String userName, RoleType type) {
        UserEntity userEntity = userService.findUserByUserName(userName);
        UserRoleEntity result = null;
        if (userEntity != null) {
            switch (type) {
                case USER:
                    result = userRoleRepo.save(UserRoleEntity.builder()
                            .userByIdUser(userEntity)
                            .roleByIdRole(roleService.getRoleByRoleName(RoleServiceImpl.USER))
                            .build());
                    break;
                case ADMIN:
                    result = userRoleRepo.save(UserRoleEntity.builder()
                            .userByIdUser(userEntity)
                            .roleByIdRole(roleService.getRoleByRoleName(RoleServiceImpl.ADMIN))
                            .build());
                    break;
                case GUEST:
                    result = userRoleRepo.save(UserRoleEntity.builder()
                            .userByIdUser(userEntity)
                            .roleByIdRole(roleService.getRoleByRoleName(RoleServiceImpl.GUEST))
                            .build());
                    break;
                case MASTER:
                    result = userRoleRepo.save(UserRoleEntity.builder()
                            .userByIdUser(userEntity)
                            .roleByIdRole(roleService.getRoleByRoleName(RoleServiceImpl.MASTER))
                            .build());
                    break;
                default:

            }
        }
        return result;
    }

    @Override
    public UserRoleEntity updateRoleUserByUserId(String userId, RoleType type) {
        return null;
    }

    private Specification<UserRoleEntity> hasUserId(UserEntity userEntity) {
        return (root, cq, cb) -> cb.equal(root.get(UserRoleEntity_.userByIdUser), userEntity);
    }

    private void setRoleDefault(String idUser) {
        UserEntity userEntity = userService.findUserByUserId(idUser);
        RoleEntity roleEntity = roleService.getRoleByRoleName(RoleServiceImpl.USER);
        if (userEntity != null && roleEntity != null) {
            userRoleRepo.save(UserRoleEntity.builder()
                    .userByIdUser(userEntity)
                    .roleByIdRole(roleEntity)
                    .build());
        }
    }

    @PreDestroy
    void preDestroy() {
        compositeDisposable.clear();
    }
}
