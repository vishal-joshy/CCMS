package com.expl.ccms.groups;

import com.expl.ccms.Configuration.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Group findByName(String name);
}
