package com.expl.ccms.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/groups/{group_id}/configurations")
public class ConfigurationController {
    private final ConfigurationService configService;

    @Autowired
    public ConfigurationController(ConfigurationService configService) {
        this.configService = configService;
    }

    @GetMapping("/")
    public ResponseEntity<Optional<Configuration>> getConfigurations(@PathVariable("group_id") Long groupId) {
        Optional<Configuration> configurations = configService.getConfigurations(groupId);
        System.out.println(configurations);
        if (configurations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(configurations, HttpStatus.OK);
    }

    @GetMapping("/{key}")
    public ResponseEntity<Configuration> getConfiguration(@PathVariable("group_id") Long groupId, @PathVariable String key, @RequestParam Optional<Long> serviceId){
        //check if there is override with service id , else return based on group id and key
        Configuration configuration= configService.getConfiguration(groupId,key,serviceId);
        return new ResponseEntity<>(configuration,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> addConfiguration(@PathVariable("group_id") Long groupId, @RequestBody ConfigurationFormData configurationFormData) {
        Configuration configuration = new Configuration(configurationFormData.key, groupId, configurationFormData.name, configurationFormData.description, configurationFormData.data);
        configService.addConfiguration(configuration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/{key}")
    public ResponseEntity<HttpStatus> updateConfiguration(@PathVariable("key") String key, @PathVariable("group-id") Long groupId, @RequestBody ConfigurationFormData configurationFormData) {
        Configuration configuration = new Configuration(key, groupId, configurationFormData.name, configurationFormData.description, configurationFormData.data);
        configService.updateConfiguration(groupId,key,configurationFormData);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
