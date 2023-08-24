package com.expl.ccms.ConfigurationOverrides;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/configuration_overrides")
public class ConfigurationOverridesController {
    private final ConfigurationOverrideService configurationOverrideService;
    @Autowired
    public ConfigurationOverridesController(ConfigurationOverrideService configurationOverrideService) {
        this.configurationOverrideService=configurationOverrideService;
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> createNewOverride(@RequestBody ConfigurationOverride override)  {
        configurationOverrideService.addOverride(override);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> addNewOverride(@RequestBody ConfigurationOverride override, @PathVariable("id")Long id){
        configurationOverrideService.updateOverride(override,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
