package com.expl.ccms.groups;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GroupConfig {
    @Bean
    CommandLineRunner commandLineRunner(GroupRepository groupRepository){
        return args->{
            Group test1 = new Group("frontend","Front end group description");
            groupRepository.save(test1);
        };
    }

}
