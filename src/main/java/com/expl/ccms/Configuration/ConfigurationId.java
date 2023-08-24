package com.expl.ccms.Configuration;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ConfigurationId implements Serializable {
    private Long groupId;
    private String key;

    public ConfigurationId(Long groupId, String key) {
        this.groupId=groupId;
        this.key=key;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
