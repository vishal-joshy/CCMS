package com.expl.ccms.groups;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name="Groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    private String name;
    private String description;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;

    protected Group(){
    }
    public Group(String name,String description){
        this.name=name;
        this.description=description;
    }

    public long getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
       return description;
    }
}
