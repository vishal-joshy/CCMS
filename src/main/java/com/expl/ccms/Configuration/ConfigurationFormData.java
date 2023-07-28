package com.expl.ccms.Configuration;

import java.util.Map;

public class ConfigurationFormData {
    public String key;
    public String name;
    public String description;
    public Long version;
    public Map<String,Object> data;

    public ConfigurationFormData(String key, String name, String description, Long version, Map<String,Object> data) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.version = version;
        this.data = data;
    }

}
