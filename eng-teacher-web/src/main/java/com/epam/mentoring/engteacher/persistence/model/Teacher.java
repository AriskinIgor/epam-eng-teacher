package com.epam.mentoring.engteacher.persistence.model;

/**
 * Entity Teacher.
 * 
 * @author Igor_Ariskin
 */
public class Teacher {

    private Administrator admin;
    private String name;

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
