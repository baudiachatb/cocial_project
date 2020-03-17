package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.endpoint.statemanager.UserState;
import com.b.myproject.entity.RoleEntity;
import com.b.myproject.entity.RoleEntity_;
import com.b.myproject.entity.UserRoleEntity;
import com.b.myproject.repository.RoleRepo;
import com.b.myproject.repository.UserRepo;
import com.b.myproject.repository.UserRoleRepo;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {
    private RoleRepo roleRepo;
    private UserRoleRepo userRoleRepo;
    private UserState userState;
    private UserRepo userRepo;
//    private CompositeDisposable compositeDisposable = new CompositeDisposable();
//    @PostConstruct
//    public void init(){
//        Disposable disposable1 = userState.updateUserAsObs().observeOn(Schedulers.io()).subscribe(idUser -> {
//            userRoleRepo.save(UserRoleEntity.builder()
//                    .userByIdUser(userRepo.findById(idUser).get())
//                    .roleByIdRole(new RoleEntity())
//            .build());
//        });
//        compositeDisposable.add(disposable1);
//    }
    Specification<RoleEntity> hasIdRole(String idRole){
        return (root, cq, cb) -> cb.equal(root.get(RoleEntity_.id), idRole);
    }

    Specification<RoleEntity> hasNameRole(String nameRole){
        return (root, cq, cb) -> cb.equal(root.get(RoleEntity_.nameRole), nameRole);
    }

//    @PreDestroy
//    public void destroy(){
//        compositeDisposable.clear();
//    }
}
