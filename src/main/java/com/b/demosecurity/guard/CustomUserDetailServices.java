package com.b.demosecurity.guard;

import com.b.demosecurity.model.user.UserEntity;
import com.b.demosecurity.repository.user.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class CustomUserDetailServices implements UserDetailsService {
    UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String idUser) throws UsernameNotFoundException {
        try{
            return new CustomUserDetail(new UserEntity());
        } catch (Exception e){
            throw new UsernameNotFoundException("User name này không tồn tại");
        }
    }
}
