package com.b.myproject.endpoint.service.group;

import com.b.myproject.entity.GroupEntity;
import com.b.myproject.repository.GroupRepo;
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
}
