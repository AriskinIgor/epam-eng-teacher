package com.epam.mentoring.engteacher.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.epam.mentoring.engteacher.persistence.model.Student;

@Stateless
public class StudentBean {
	
	@PersistenceContext
	private EntityManager em;

	public void create(Student... stud) {
		for (Student s : stud) {
			em.persist(s);
		}
	}

	public Student getStudentByName(String name) {
		return (Student) em
				.createQuery("select s from Student s where s.name = :name")
				.setParameter("name", name).getSingleResult();
	}
}
