package com.epam.mentoring.engteacher.persistence.model;

import java.util.List;

/**
 * Entity Group.
 * 
 * @author Igor_Ariskin
 */
public class Group {

    private List<Student> students;
    private Teacher teacher;
    private String name;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
