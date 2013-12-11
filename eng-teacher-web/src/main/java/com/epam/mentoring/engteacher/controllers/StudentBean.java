package com.epam.mentoring.engteacher.controllers;

import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.epam.mentoring.engteacher.persistence.model.Student;

@Stateless
public class StudentBean {

	@PersistenceContext(unitName = "epmteacher-pu")
	private EntityManager entityManager;

	public Student save(Student stud) {
		Student newStud = null;
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			newStud = entityManager.merge(stud);
			entityManager.flush();
			tx.commit();
			return newStud;
		} catch (RuntimeException e) {
			e.printStackTrace();
			if (tx != null){
				tx.rollback();
			}
			return null;
		}
	}

	@PermitAll
	public Student getStudentById(Long id) {
		return (Student) entityManager
				.createQuery("select s from Student s where s.id = :id")
				.setParameter("id", id).getSingleResult();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
