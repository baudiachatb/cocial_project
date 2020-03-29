package com.b.myproject.endpoint.service;

import com.b.myproject.endpoint.service.group.IGroupService;
import com.b.myproject.endpoint.service.role.IRoleService;
import com.b.myproject.endpoint.service.user.IUserService;
import com.b.myproject.endpoint.service.userdetailgoogle.IUserDetailGoogleService;
import com.b.myproject.endpoint.service.userrole.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceComposite {
    public final IRoleService roleService;
    public final IUserService userService;
    public final IUserRoleService userRoleService;
    public final IGroupService groupService;
    public final IUserDetailGoogleService userDetailGoogleService;
}
