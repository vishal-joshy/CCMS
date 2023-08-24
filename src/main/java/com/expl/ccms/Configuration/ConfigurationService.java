package com.expl.ccms.Configuration;

import com.expl.ccms.ConfigurationOverrides.ConfigurationOverride;
import com.expl.ccms.ConfigurationOverrides.ConfigurationOverridesRepository;
import com.expl.ccms.Groups.Group;
import com.expl.ccms.Groups.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ConfigurationService{
    private final ConfigurationRepository configurationRepository;
    private final ConfigurationOverridesRepository configurationOverridesRepository;
    private final GroupService groupService;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository, ConfigurationOverridesRepository configurationOverridesRepository, GroupService groupService) {
        this.configurationRepository = configurationRepository;
        this.configurationOverridesRepository = configurationOverridesRepository;
        this.groupService = groupService;
    }

    public Optional<Configuration> getConfigurations(Long groupId){
        //check if group exists
        Group group = groupService.getGroup(groupId);
        List<Configuration> configurations = configurationRepository.findAll();
        ConfigurationId configurationId = new ConfigurationId(groupId,"metrics");
        return configurationRepository.findById(configurationId);
    }

    public Configuration getConfiguration(Long groupId, String key, Optional<Long> serviceId){
        Group group = groupService.getGroup(groupId);

        if(serviceId.isPresent()){
            ConfigurationOverride override = configurationOverridesRepository.findAllByGroupIdAndServiceId(groupId,serviceId);
            System.out.println(override);
            //get configuration key from override repository
            // return configuration of latest version
        }

        // check for latest version, if override exists get latest version of override
        return null;
    }

    public void addConfiguration(Configuration configuration) {
        ConfigurationId configurationId = new ConfigurationId(configuration.getGroupId(),configuration.getKey());
        Optional<Configuration> configurationData = configurationRepository.findById(configurationId);
        if(configurationData.isPresent()){
            throw new DuplicateKeyException("Configuration already exists , update to create a new version");
        }
        configuration.setVersion(1L);
        configurationRepository.save(configuration);
    }

    public void updateConfiguration(Long groupId, String key, ConfigurationFormData formData){
        ConfigurationId configurationId = new ConfigurationId(groupId,key);
        Optional<Configuration> configurationData = configurationRepository.findById(configurationId);
        if(configurationData.isPresent()){
            Configuration existingConfig = configurationData.get();
            Configuration newConfiguration = new Configuration(key,groupId,formData.name, formData.description,formData.data);
            newConfiguration.setVersion(existingConfig.getVersion()+1);
            configurationRepository.save(newConfiguration);
        } else {
            throw new NoSuchElementException("Cannot find configuration");
        }
    }
}