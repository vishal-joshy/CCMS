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

    public List<Configuration> getConfigurations(){
        return configurationRepository.findAllByGroupId(1L);
    }
}