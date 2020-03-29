package com.b.myproject.endpoint.service.group;

import com.b.myproject.endpoint.controller.payload.SearchParams;
import com.b.myproject.entity.GroupEntity;
import com.b.myproject.repository.GroupRepo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GroupServiceImpl implements IGroupService {

    private final GroupRepo groupRepo;

    @Override
    public GroupEntity getGroupByNameGroup(String nameGroup) throws RuntimeException {
        try {
            return groupRepo.getOne(nameGroup);

        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public GroupEntity getById(String id) {
        return groupRepo.getOne(id);
    }

    @Override
    public List<GroupEntity> getAll() {
        return null;
    }

    @Override
    public List<GroupEntity> search(SearchParams searchParams) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        groupRepo.deleteById(id);
    }

    @Override
    public GroupEntity create(GroupEntity groupEntity) {
        return groupRepo.save(groupEntity);
    }

    @Override
    public GroupEntity update(GroupEntity groupEntity) {
        return groupRepo.save(groupEntity);
    }
}
