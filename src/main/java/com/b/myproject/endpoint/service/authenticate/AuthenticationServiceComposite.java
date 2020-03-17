package com.b.myproject.endpoint.service.authenticate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AuthenticationServiceComposite {
    @Autowired
    public RoleService roleService;
    @Autowired
    public UserService userService;
    @Autowired
    public UserRoleService userRoleService;
}
