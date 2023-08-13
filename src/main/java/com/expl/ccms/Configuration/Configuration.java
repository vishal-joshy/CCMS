package com.expl.ccms.Configuration;

import com.expl.ccms.Utils.HashMapConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.IOException;
import java.sql.Time;
import java.util.Map;

@Entity
public class Configuration{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String key;
    private Long groupId;
    private String name;
    private String description;
    private Long version;
    @Convert(converter = HashMapConverter.class)
    private Map<String,Object> data;
    @CreationTimestamp
    private Time created_on;
    @UpdateTimestamp
    private Time updated_on;


    public Configuration(String key, Long group_id, String name, String description, Long version, Map<String,Object> data) {
        this.key = key;
        this.groupId = group_id;
        this.name = name;
        this.description = description;
        this.version = version;
        this.data = data;
    }

    protected Configuration(){

    }

    public void serializeAttributes() throws JsonProcessingException {

    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public Map<String,Object> getData() {
        return data;
    }

}

