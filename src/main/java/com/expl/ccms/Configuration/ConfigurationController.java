package com.expl.ccms.Configuration;

import com.expl.ccms.groups.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/{group_id}/configuration")
public class ConfigurationController {
    private final ConfigurationService configService;
    @Autowired
    public ConfigurationController(ConfigurationService configService){
        this.configService=configService;
    }
    @GetMapping
    public List<Configuration> getConfig() {
        return configService.getConfigurations();
    }

    @PostMapping(path = "{id}")
    public void addConfiguration(@RequestBody Configuration configuration){

    }
}
