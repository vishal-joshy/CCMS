package com.expl.ccms.Configuration;

import com.expl.ccms.Utils.HashMapConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ConfigurationId.class)
public class Configuration {
    @Id
    private Long groupId;
    @Id
    private String key;

    private String name;
    private String description;
    private Long version;
    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> data;
    @CreationTimestamp
    private Time created_on;
    @UpdateTimestamp
    private Time updated_on;

    public Configuration(String key, Long groupId, String name, String description, Map<String, Object> data) {
        this.key=key;
        this.groupId=groupId;
        this.name=name;
        this.description=description;
        this.data=data;
    }

    public Long getGroupId() {
        return groupId;
    }

    public String getKey() {
        return key;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}

