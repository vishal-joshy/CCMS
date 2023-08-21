package com.expl.ccms.Groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Group>> getGroups() {
        List<Group> groups = groupService.getGroups();
        if (groups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroup(@PathVariable("id") Long id) {
        Group group = groupService.getGroup(id);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Group> addNewGroup(@RequestBody Group group) {
        groupService.addGroup(group);
        return new ResponseEntity<>(group, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Group> updateGroup(@RequestBody Group groupFormData, @PathVariable("id") Long id) {
        groupService.updateGroup(groupFormData, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
