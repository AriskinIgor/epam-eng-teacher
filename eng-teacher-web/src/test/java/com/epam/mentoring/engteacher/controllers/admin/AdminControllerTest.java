package com.epam.mentoring.engteacher.controllers.admin;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.naming.directory.InvalidAttributesException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.mentoring.engteacher.controllers.StudentBean;
import com.epam.mentoring.engteacher.persistence.model.Student;
import com.epam.mentoring.engteacher.validators.StudentValidator;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

	private Student validStudent;

	private static final String validFirstName = "Петр";

	private static final String validLastName = "Иванов";

	private static final String validPatronymic = "Сидоров";

	private static final String validBirthday = "06.01.1991";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	@Mock
	private StudentValidator validator;

	@Mock
	private StudentBean studentBean;

	@InjectMocks
	private AdminController adminController;

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
		when(validator.validate(validStudent)).thenReturn(true);
		when(studentBean.save(validStudent)).thenReturn(validStudent);
		assertTrue(adminController.addNewStudent(validStudent));
	}

	@Ignore("Not Ready to Run")
	@Test
	public void divisionWithException() {
		System.out.println("Method is not ready yet");
	}
}
