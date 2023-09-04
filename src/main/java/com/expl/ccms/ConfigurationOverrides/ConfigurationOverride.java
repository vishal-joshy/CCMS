package com.expl.ccms.ConfigurationOverrides;

import jakarta.persistence.*;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class ConfigurationOverride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    String name;
    private Long serviceId;
    private Long groupId;
    private String configurationKey;
    private Long version;
    private String description;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getConfigurationKey() {
        return configurationKey;
    }

    public void setConfigurationKey(String configurationKey) {
        this.configurationKey = configurationKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
