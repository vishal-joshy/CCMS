package com.expl.ccms.Configuration;

public class ConfigurationFormData {
    public String key;
    public String name;
    public String description;
    public Long version;
    public String data;

    public ConfigurationFormData(String key, String name, String description, Long version, String data) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.version = version;
        this.data = data;
    }

}
