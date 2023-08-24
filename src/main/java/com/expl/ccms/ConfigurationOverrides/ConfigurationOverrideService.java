package com.expl.ccms.ConfigurationOverrides;

import com.expl.ccms.Configuration.ConfigurationRepository;
import org.springframework.stereotype.Service;


@Service
public class ConfigurationOverrideService {
    private final ConfigurationOverridesRepository configurationOverridesRepository;

    public ConfigurationOverrideService(ConfigurationOverridesRepository configurationOverridesRepository) {
        this.configurationOverridesRepository = configurationOverridesRepository;
    }

    public void addOverride(ConfigurationOverride override) {
        override.setVersion(1L);
        configurationOverridesRepository.save(override);
    }

    public void updateOverride(ConfigurationOverride override, Long id){
        override.setVersion(override.getVersion()+1);
        configurationOverridesRepository.save(override);
    }
}
