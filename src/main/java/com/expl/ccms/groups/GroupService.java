package com.expl.ccms.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

   public void addGroup(Group group) {
      groupRepository.save(group);
   }

   public void updateGroup(Group group, Long id){
      boolean exists = groupRepository.existsById(id);
      if(!exists){
         throw new IllegalStateException(
                 "Group with id " + id + "does not exist."
         );
      }
      group.setId(id);
      groupRepository.save(group);
   }

   public void deleteGroup(Long id) {
      groupRepository.deleteById(id);
   }
}
