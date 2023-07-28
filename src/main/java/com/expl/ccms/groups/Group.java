package com.expl.ccms.groups;

import jakarta.persistence.*;

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
