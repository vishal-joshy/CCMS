package com.expl.ccms.Configuration;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Configuration{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String key;
    private Long groupId;
    private String name;
    private String description;
    private Long version;
    private String data;


    public Configuration(String key, Long group_id, String name, String description, Long version, String data) {
        this.key = key;
        this.groupId = group_id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getVersion() {
        return version;
    }

    public String getData() {
        return data;
    }

}
