package com.b.myproject.Security;

import com.b.myproject.endpoint.service.UserRoleService;
import com.b.myproject.endpoint.service.UserService;
import com.b.myproject.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new CustomUserDetails(getUser(username), getAuthorities(username));
    }

    private UserEntity getUser(String userName) {
        return userService.findUserByUserName(userName);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String userName) {
        String idUser = getUser(userName).getId();
        return userRoleService.findAllByUserId(idUser)
                .stream()
                .map(
                        userRoleEntity -> new SimpleGrantedAuthority(
                                userRoleEntity.getRoleByIdRole().getNameRole()
                        )
                ).collect(Collectors.toList());
    }
}

