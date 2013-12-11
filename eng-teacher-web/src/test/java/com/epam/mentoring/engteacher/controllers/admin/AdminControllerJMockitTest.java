package com.epam.mentoring.engteacher.controllers.admin;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.enterprise.inject.spi.Bean;
import javax.naming.NamingException;
import javax.naming.directory.InvalidAttributesException;

import mockit.Expectations;
import mockit.Injectable;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import mockit.Tested;
import mockit.VerificationsInOrder;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.epam.mentoring.engteacher.controllers.StudentBean;
import com.epam.mentoring.engteacher.persistence.model.Student;
import com.epam.mentoring.engteacher.validators.StudentValidator;

public class AdminControllerJMockitTest {

	private Student validStudent;

	private static final String validFirstName = "Петр";

	private static final String validLastName = "Иванов";

	private static final String validPatronymic = "Сидоров";

	private static final String validBirthday = "06.01.1991";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	@Mocked
	StudentValidator validator;

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

		new Expectations() {
			{
			}
		};

		new NonStrictExpectations() {
			{
				validator.validate(validStudent);
				result = true;
				times = 1;
				studentBean.save(validStudent);
				result = validStudent;
				times = 1;
			}
		};

		adminController.setBean(studentBean);
		boolean actual = adminController.addNewStudent(validStudent);
		System.out.println(actual);
		assertTrue(actual);
	}

	@Test(expected = InvalidAttributesException.class)
	public void testAddNewStudentInvalid() throws InvalidAttributesException {

		new Expectations() {
			{
			}
		};

		new NonStrictExpectations() {
			{
				validator.validate(validStudent);
				result = false;
				times = 1;
				studentBean.save(validStudent);
				times = 0;
			}
		};

		adminController.setBean(studentBean);
		boolean actual = adminController.addNewStudent(validStudent);
		assertTrue(actual);

		new VerificationsInOrder() {
			{
				validator.validate(validStudent);
				studentBean.save(validStudent);
			}
		};
	}

}
