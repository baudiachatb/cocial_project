package com.b.myproject.endpoint.service.authenticate;

import com.b.myproject.endpoint.statemanager.UserState;
import com.b.myproject.entity.UserEntity;
import com.b.myproject.entity.UserEntity_;
import com.b.myproject.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    private UserState userState;

    @Override
    public UserEntity findUserByUserName(String userName) {
        return userRepo.findOne(Specification.where(hasUserName(userName))).orElse(null);
    }

    /**
     * Tạo mới user
     * Nếu tạo thành công thì update userState id User vừa tạo
     * Các chức năng liên quan có thể lấy thông tin từ
     * @param userEntity
     * @return
     */
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity user = userRepo.save(userEntity);
        if(user!= null){
            userState.sendUpdateUser(user.getId());
        }
        return user;
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    private Specification<UserEntity> hasUserName(String userName) {
        return (root, cq, cb) -> cb.equal(root.get(UserEntity_.username), userName);
    }
}
