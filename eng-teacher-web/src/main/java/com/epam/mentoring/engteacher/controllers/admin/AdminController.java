package com.epam.mentoring.engteacher.controllers.admin;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.directory.InvalidAttributesException;

import com.epam.mentoring.engteacher.controllers.StudentBean;
import com.epam.mentoring.engteacher.persistence.model.Student;
import com.epam.mentoring.engteacher.validators.StudentValidator;

@Stateless
public class AdminController {

	@EJB
	private StudentBean bean;

	public boolean addNewStudent(Student stud) throws InvalidAttributesException {
		StudentValidator validator = new StudentValidator();
		if (validator.validate(stud)) {
			return (bean.save(stud) != null);
		}
		throw new InvalidAttributesException("student data are invalid!");
	}
	
	public void setBean(StudentBean bean) {
		this.bean = bean;
	}
}
