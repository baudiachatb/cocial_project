package com.b.demosecurity.guard;

import com.b.demosecurity.model.user.RoleEntity;
import com.b.demosecurity.model.user.UserEntity;
import com.b.demosecurity.service.user.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CustomUserDetail implements UserDetails {
    private UserEntity user;
    @Autowired
    UserRoleService userRoleService;
    CustomUserDetail(UserEntity userEntity){
        this.user = userEntity;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<? extends GrantedAuthority> roles = userRoleService.getListRoleByIdUser(user.getIdUser())
                .stream()
                .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getNameRole()))
                .collect(Collectors.toList());
        return roles;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
