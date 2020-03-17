package com.b.myproject.Security;

import com.b.myproject.endpoint.service.authenticate.AuthenticationServiceComposite;
import com.b.myproject.endpoint.service.authenticate.UserRoleService;
import com.b.myproject.endpoint.service.authenticate.UserService;
import com.b.myproject.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomUserDetailsService implements UserDetailsService {
//    private AuthenticationServiceComposite authenticationServiceComposite;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new CustomUserDetails(getUser(username), getAuthorities(username));
        UserDetails user = new User("test1", passwordEncoder.encode("1234"), AuthorityUtils.createAuthorityList("ROLE_USER"));
        return user;
    }

//    private UserEntity getUser(String userName) {
//        return authenticationServiceComposite.userService.findUserByUserName(userName);
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(String userName) {
//        String idUser = getUser(userName).getId();
//        return authenticationServiceComposite.userRoleService.findAllByUserId(idUser)
//                .stream()
//                .map(
//                        userRoleEntity -> new SimpleGrantedAuthority(
//                                userRoleEntity.getRoleByIdRole().getNameRole()
//                        )
//                ).collect(Collectors.toList());
//    }
}

