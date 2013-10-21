package com.epam.mentoring.engteacher.persistence.model;

/**
 * Entity Student.
 * 
 * @author Igor_Ariskin
 */
public class Student {

    private Teacher teacher;
    private Group group;
    private String name;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
