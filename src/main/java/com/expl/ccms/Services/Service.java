package com.expl.ccms.Services;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    protected Service(){
    }
    public Service(String name,String description){
        this.name=name;
        this.description=description;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id=id;
    }
}
