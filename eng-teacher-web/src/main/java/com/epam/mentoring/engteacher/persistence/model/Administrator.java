package com.epam.mentoring.engteacher.persistence.model;


/**
 * Entity Administrator.
 *
 * @author Igor_Ariskin
 */
public class Administrator {

    private String name;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
