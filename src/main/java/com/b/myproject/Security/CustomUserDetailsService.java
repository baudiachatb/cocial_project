package com.b.myproject.Security;

import com.b.myproject.endpoint.service.ServiceComposite;
import com.b.myproject.entity.UserEntity;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserDetailsService implements UserDetailsService {
    private final ServiceComposite serviceComposite;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserDetails(getUser(username), getAuthorities(username));
    }

    private UserEntity getUser(String userName) {
        return serviceComposite.userService.findUserByUserName(userName);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String userName) {
        String idUser = getUser(userName).getId();
        return serviceComposite.userRoleService.findAllByUserId(idUser)
                .stream()
                .map(
                        userRoleEntity -> new SimpleGrantedAuthority(
                                userRoleEntity.getRoleByIdRole().getNameRole()
                        )
                ).collect(Collectors.toList());
    }
}

