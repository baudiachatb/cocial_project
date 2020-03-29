package com.b.myproject.endpoint.service.userrole;

import com.b.myproject.endpoint.service.role.IRoleService;
import com.b.myproject.endpoint.service.role.RoleServiceImpl;
import com.b.myproject.endpoint.service.role.RoleType;
import com.b.myproject.endpoint.service.user.IUserService;
import com.b.myproject.endpoint.statemanager.StateComposite;
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
public class UserRoleServiceImpl implements IUserRoleService {
    private final UserRoleRepo userRoleRepo;
    private final StateComposite stateComposite;
    private final IUserService userService;
    private final IRoleService roleService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @PostConstruct
    void init() {
        Disposable disposable1 = stateComposite.userStateService.stateAsObs()
                .map(stateEnt -> (UserEntity)stateEnt.entity)
                .subscribe(this::setRoleDefault);
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

    private void setRoleDefault(UserEntity userEntity) {
        RoleEntity roleEntity = roleService.getRoleByRoleName(RoleServiceImpl.USER);
        if (userEntity != null && roleEntity != null) {
            userRoleRepo.save(UserRoleEntity.builder()
                    .userByIdUser(userEntity)
                    .username(userEntity.getUsername())
                    .roleByIdRole(roleEntity)
                    .nameRole(roleEntity.getNameRole())
                    .build());
        }
    }

    @PreDestroy
    void preDestroy() {
        compositeDisposable.clear();
    }
}
