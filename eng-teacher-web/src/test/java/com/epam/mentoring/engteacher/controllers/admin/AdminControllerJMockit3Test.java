package com.epam.mentoring.engteacher.controllers.admin;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.naming.directory.InvalidAttributesException;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;

import org.junit.Before;
import org.junit.Test;

import com.epam.mentoring.engteacher.controllers.StudentBean;
import com.epam.mentoring.engteacher.persistence.model.Student;
import com.epam.mentoring.engteacher.validators.StudentValidator;

public class AdminControllerJMockit3Test {
	private Student validStudent;

	private static final String validFirstName = "Петр";

	private static final String validLastName = "Иванов";

	private static final String validPatronymic = "Сидоров";

	private static final String validBirthday = "06.01.1991";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	@Mocked
	StudentBean studentBean;

	@Tested
	AdminController adminController;

	@Before
	public void setUp() throws ParseException, NamingException {
		validStudent = new Student();
		validStudent.setLastName(validLastName);
		validStudent.setFirstName(validFirstName);
		validStudent.setPatronymic(validPatronymic);
		validStudent.setBirthday(sdf.parse(validBirthday));
	}


	@Test
	public void testAddNewStudent() throws InvalidAttributesException {
		new NonStrictExpectations() {
			{
				studentBean.save(validStudent);
				result = validStudent;
				times = 1;
			}
		};

		adminController.setBean(studentBean);
		boolean actual = adminController.addNewStudent(validStudent);
		assertTrue(actual);
	}

	@Test(expected = InvalidAttributesException.class)
	public void testAddNewStudentInvalid() throws InvalidAttributesException {

		new MockUp<StudentValidator>() {
			
			@Mock(invocations = 1)
			boolean validate(Student stud) throws InvalidAttributesException {
				assertNotNull(stud);
				throw new InvalidAttributesException();
			}
		};

		new NonStrictExpectations() {
			{
				studentBean.save(validStudent);
				times = 0;
			}
		};

		adminController.setBean(studentBean);

		boolean actual = adminController.addNewStudent(validStudent);
		assertTrue(actual);

	}
}
