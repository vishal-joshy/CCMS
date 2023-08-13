package com.expl.ccms.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
   private final GroupRepository groupRepository;

   @Autowired
   public GroupService(GroupRepository groupRepository){
      this.groupRepository=groupRepository;
   }
   public List<Group> getGroups() {
      return groupRepository.findAll();
   }
   public Optional<Group> getGroup(Long id){
      return groupRepository.findById(id);
   }

   public void addGroup(Group group) {
      groupRepository.save(group);
   }

   public void updateGroup(Group group, Long id){
      group.setId(id);
      groupRepository.save(group);
   }

   public void deleteGroup(Long id) {
      groupRepository.deleteById(id);
   }
}
