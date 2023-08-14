package com.expl.ccms.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroup(Long id) {
        return Optional.ofNullable(groupRepository.findById(id).orElse(null));
    }

    public void addGroup(Group group) {
        Group groupData = groupRepository.findByName(group.getName());
        if (groupData != null) {
            throw new DuplicateKeyException("Group with" + group.getName() + " already exists");
        } else {
            groupRepository.save(group);
        }
    }

    public void updateGroup(Group group, Long id) {
        Group groupNameData = groupRepository.findByName(group.getName());
        if(groupNameData != null){
            throw new DuplicateKeyException("Group name must be unique");
        }else {
            Optional<Group> groupIdData = groupRepository.findById(id);
            if(groupIdData.isPresent()){
                group.setId(id);
                groupRepository.save(group);
            }
           else {
               throw new NoSuchElementException("Group with id"+id+" not found");
            }
        }
    }

    public void deleteGroup(Long id) {
        Optional<Group> group = groupRepository.findById(id);
        if(group.isPresent()){
            groupRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Group with id:"+id+" doesn't exist");
        }

    }
}
