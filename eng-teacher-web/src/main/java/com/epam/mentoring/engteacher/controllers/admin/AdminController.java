package com.epam.mentoring.engteacher.controllers.admin;

import javax.ejb.EJB;

import com.epam.mentoring.engteacher.controllers.StudentBean;
import com.epam.mentoring.engteacher.persistence.model.Student;
import com.epam.mentoring.engteacher.validators.StudentValidator;

public class AdminController {

	@EJB
	private StudentBean bean;
	
	@EJB
	private StudentValidator validator;

	public boolean addNewStudent(Student stud) {
		if (validator.validate(stud)) {
			bean.create(stud);
			return true;
		}
		return false;
	}
}
