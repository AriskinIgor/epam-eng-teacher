package com.epam.mentoring.engteacher.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.epam.mentoring.engteacher.persistence.model.Student;

@RunWith(MockitoJUnitRunner.class)
public class StudentBeanITest {

	private Student validStudent;

	private static final String validFirstName = "Петр";

	private static final String validLastName = "Иванов";

	private static final String validPatronymic = "Сидоров";

	private static final String validBirthday = "06.01.1991";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	@Spy
	private StudentBean studentBean;

	@InjectMocks
	private StudentBean studentBeanMock;
	@Spy
	private static EntityManager entityManager;

	@BeforeClass
	public static void createEntityManager() {
		entityManager = Persistence.createEntityManagerFactory("epmteacher-pu")
				.createEntityManager();

	}

	@Before
	public void setUp() throws ParseException, NamingException {
		validStudent = new Student();
		validStudent.setLastName(validLastName);
		validStudent.setFirstName(validFirstName);
		validStudent.setPatronymic(validPatronymic);
		validStudent.setBirthday(sdf.parse(validBirthday));
		studentBean.setEntityManager(entityManager);
	}

	@Test
	public void testCreate() {
		Student result = studentBean.save(validStudent);
		assertNotNull(result.getId());
		Student actual = studentBean.getStudentById(result.getId());
		assertEquals(result.getId(), actual.getId());
		assertEquals(result, actual);
	}

	@Test
	public void testCreateSpyMethod() {
		when(entityManager.merge(validStudent)).thenReturn(validStudent);
		Student result = studentBean.save(validStudent);
		assertNull(result.getId());
	}
}
