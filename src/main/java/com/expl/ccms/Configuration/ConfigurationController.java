package com.expl.ccms.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/{group_id}/configurations")
public class ConfigurationController {
    private final ConfigurationService configService;

    @Autowired
    public ConfigurationController(ConfigurationService configService) {
        this.configService = configService;
    }

    @GetMapping()
    public ResponseEntity<List<Configuration>> getConfigurations(@PathVariable("group_id") Long groupId) {
        List<Configuration> configurations = configService.getConfigurations(groupId);
        if (configurations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(configurations, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> addConfiguration(@PathVariable("group_id") Long groupId, @RequestBody ConfigurationFormData configurationFormData) {
        Configuration configuration = new Configuration(configurationFormData.key, groupId, configurationFormData.name, configurationFormData.description, configurationFormData.version, configurationFormData.data);
        configService.addConfiguration(configuration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "{configuration_id}")
    public ResponseEntity<HttpStatus> updateConfiguration(@PathVariable("configuration_id") Long configurationId, @PathVariable("group-id") Long groupId, @RequestBody ConfigurationFormData configurationFormData) {
        Configuration configuration = new Configuration(configurationFormData.key, groupId, configurationFormData.name, configurationFormData.description, configurationFormData.version, configurationFormData.data);
        configService.updateConfiguration(configurationId, configuration);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "{configuration_id}")
    public ResponseEntity<HttpStatus> deleteConfiguration(@PathVariable("configuration_id") Long configurationId) {
        configService.deleteConfiguration(configurationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
