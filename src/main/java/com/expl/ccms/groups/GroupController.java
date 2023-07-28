package com.expl.ccms.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path="api/groups")
public class GroupController{
    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService){
        this.groupService=groupService;
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PostMapping
    public void addNewGroup(@RequestBody Group group){
        groupService.addGroup(group);
    }

    @PutMapping(path = "{groupId}")
    public void updateGroup(@RequestBody Group group, @PathVariable("groupId") Long id){
        groupService.updateGroup(group,id);
    }

    @DeleteMapping(path = "{groupId}")
    public void deleteGroup(@PathVariable("groupId") Long id){
        groupService.deleteGroup(id);
    }
}
