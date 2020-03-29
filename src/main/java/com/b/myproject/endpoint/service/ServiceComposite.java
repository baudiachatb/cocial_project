package com.b.myproject.endpoint.service;

import com.b.myproject.endpoint.service.role.IRoleService;
import com.b.myproject.endpoint.service.user.IUserService;
import com.b.myproject.endpoint.service.userrole.IUserRoleService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ServiceComposite {
    @Autowired
    public IRoleService roleService;
    @Autowired
    public IUserService userService;
    @Autowired
    public IUserRoleService userRoleService;
}
