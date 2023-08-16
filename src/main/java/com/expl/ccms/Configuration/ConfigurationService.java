package com.expl.ccms.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
            throw new NoSuchElementException("Configuration with id "+id+"not found");
        }
        configuration.setId(id);
        configurationRepository.save(configuration);
    }

    public void deleteConfiguration(Long id) {
        boolean exists = configurationRepository.existsById(id);
        if(!exists){
            throw new NoSuchElementException("Configuration with id "+id +"not found");
        }
        configurationRepository.deleteById(id);
    }
}