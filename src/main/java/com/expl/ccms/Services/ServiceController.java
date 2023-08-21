package com.expl.ccms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "api/service")
public class ServiceController {
    private final ServiceService serviceService;
    @Autowired
    public ServiceController(ServiceService serviceService){
        this.serviceService=serviceService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Service>> getServices(){
        List<Service> services = serviceService.getServices();
        if (services.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> getService(@PathVariable("id") Long id){
        Service service = serviceService.getService(id);
        return new ResponseEntity<>(service,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<HttpStatus> addService(@RequestBody Service service){
        serviceService.addService(service);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateService(@RequestBody Service service,@PathVariable("id") Long id){
        serviceService.updateService(service,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteService(@PathVariable("id") Long id){
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
