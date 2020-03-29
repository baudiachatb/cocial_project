package com.b.myproject.endpoint.service.group;

import com.b.myproject.endpoint.controller.payload.SearchParams;
import com.b.myproject.entity.GroupEntity;
import java.util.List;
public interface IGroupService {
    GroupEntity getGroupByNameGroup(String nameGroup) throws Exception;
    GroupEntity getById(String id);
    List<GroupEntity> getAll();
    List<GroupEntity> search(SearchParams searchParams);
    void deleteById(String id);
    GroupEntity create(GroupEntity groupEntity);
    GroupEntity update(GroupEntity groupEntity);
}
