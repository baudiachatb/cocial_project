package com.b.myproject.endpoint.service.group;

import com.b.myproject.entity.GroupEntity;

public interface IGroupService {
    GroupEntity getGroupByNameGroup(String nameGroup) throws Exception;
}
