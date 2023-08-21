package com.expl.ccms.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {
    private final ServiceRepository serviceRepository;
    @Autowired
    public ServiceService(ServiceRepository serviceRepository){
        this.serviceRepository=serviceRepository;
    }

    public List<Service> getServices(){
        return serviceRepository.findAll();
    }

    public Service getService(Long id){
        Optional<Service> service= serviceRepository.findById(id);
        if(service.isPresent()){
            return service.get();
        } else {
            throw new NoSuchElementException("Service with id"+id+" not found.");
        }
    }

    public void addService(Service service) {
        Service serviceData = serviceRepository.findByName(service.getName());
        if(serviceData != null){
            throw new DuplicateKeyException("Service with name"+ service.getName()+" already exists.");
        } else {
            serviceRepository.save(service);
        }
    }

    public void updateService(Service service, Long id) {
        Service serviceNameData= serviceRepository.findByName(service.getName());
        if (serviceNameData != null){
            throw new DuplicateKeyException("Service name must be unique");
        } else {
            Optional<Service> serviceIdData = serviceRepository.findById(id);
            if (serviceIdData.isPresent()){
                service.setId(id);
                serviceRepository.save(service);
            } else {
                throw new NoSuchElementException("Service with id"+id+" not found");
            }
        }
    }

    public void deleteService(Long id) {
        Optional<Service> service= serviceRepository.findById(id);
        if(service.isPresent()){
            serviceRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Group with id:"+ id +" does not exist");
        }
    }


}
