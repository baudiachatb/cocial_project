package com.b.myproject.endpoint.service.authenticate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationServiceComposite {
    public RoleService roleService;
    public UserService userService;
    public UserRoleService userRoleService;
}
