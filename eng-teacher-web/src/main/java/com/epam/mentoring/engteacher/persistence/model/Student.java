package com.epam.mentoring.engteacher.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity Student.
 *
 * @author Igor_Ariskin
 */
@Entity
@Table (name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "project_id_seq")
    @SequenceGenerator (name = "project_id_seq", sequenceName = "project_id_seq", allocationSize = 1)
    private Long id;

    private Teacher teacher;
    private Group group;
    @Column(name = "NAME")
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
