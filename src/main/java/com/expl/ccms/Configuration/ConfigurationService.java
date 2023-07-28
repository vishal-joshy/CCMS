package com.expl.ccms.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService{
    private final ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository){
        this.configurationRepository=configurationRepository;
    }

    public List<Configuration> getConfigurations(Long groupId){
        return configurationRepository.findAllByGroupId(groupId);
    }

    public void addConfiguration(Configuration configuration) {
        configurationRepository.save(configuration);
    }

    public void updateConfiguration(Long id,Configuration configuration){
        boolean exists = configurationRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "Configuration with id " + id + "does not exist."
            );
        }
        configuration.setId(id);
        configurationRepository.save(configuration);
    }

    public void deleteConfiguration(Long configurationId) {
        configurationRepository.deleteById(configurationId);
    }
}