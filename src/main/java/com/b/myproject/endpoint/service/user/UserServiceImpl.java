package com.b.myproject.endpoint.service.user;

import com.b.myproject.endpoint.statemanager.ActionType;
import com.b.myproject.endpoint.statemanager.StateComposite;
import com.b.myproject.endpoint.statemanager.StateEntity;
import com.b.myproject.entity.UserEntity;
import com.b.myproject.entity.UserEntity_;
import com.b.myproject.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements IUserService {
    private final UserRepo userRepo;
    private final StateComposite stateComposite;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Tìm kiếm người dùng thông qua username
     *
     * @param userName
     * @return
     */
    @Override
    public UserEntity findUserByUserName(String userName) {
        return userRepo.findOne(Specification.where(hasUserName(userName))).orElse(null);
    }

    /**
     * Tìm kiếm người dùng thông qua idUser
     *
     * @param userId
     * @return
     */
    @Override
    public UserEntity findUserByUserId(String userId) {
        return userRepo.findOne(Specification.where(hasUserId(userId))).orElse(null);
    }

    /**
     * Tạo mới user
     * Nếu tạo thành công thì update userState id User vừa tạo
     * Các chức năng liên quan có thể lấy thông tin từ
     *
     * @param userEntity
     * @return
     */
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        UserEntity user = userRepo.save(userEntity);
        if (user != null) {
            stateComposite.userStateService.sendState(StateEntity.builder()
                    .actionType(ActionType.USER_CREATE)
                    .entity(user)
                    .build());
        }
        return user;
    }

    /**
     * Cập nhật User
     *
     * @param userEntity
     * @return
     */
    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        try {
            UserEntity result = userRepo.save(userEntity);
            stateComposite.userStateService.sendState(StateEntity.builder()
                    .actionType(ActionType.USER_UPDATE)
                    .entity(result)
                    .build());
            return result;

        } catch (Exception e) {
            throw new RuntimeException("Lỗi cập nhật");
        }
    }

    /**
     * Xóa User dựa trên idUser
     *
     * @param idUser
     */
    @Override
    public void deleteUser(String idUser) {
        try {
            userRepo.deleteById(idUser);
        } catch (Exception e) {
            throw new RuntimeException("Có lỗi khi xóa");
        }
    }

    /**
     * Tìm kiếm theo userName
     *
     * @param userName
     * @return
     */
    private Specification<UserEntity> hasUserName(String userName) {
        return (root, cq, cb) -> cb.equal(root.get(UserEntity_.username), userName);
    }

    /**
     * Timd kiếm theo UserId
     *
     * @param userId
     * @return
     */
    private Specification<UserEntity> hasUserId(String userId) {
        return (root, cq, cb) -> cb.equal(root.get(UserEntity_.id), userId);
    }
}
