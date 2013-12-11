package com.epam.mentoring.engteacher.controllers;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.mentoring.engteacher.persistence.model.Student;

public class StudentBean2ITest {

	private static EJBContainer ejbContainer;

	private static Context ctx;

	private Student validStudent;

	private static final String validFirstName = "Петр";

	private static final String validLastName = "Иванов";

	private static final String validPatronymic = "Сидоров";

	private static final String validBirthday = "06.01.1991";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	@EJB
	private StudentBean studentBean;

	@Resource
	private UserTransaction userTransaction;

	EntityManager entityManager;

	@BeforeClass
	public static void startEJBContainer() throws NamingException {
		ejbContainer = EJBContainer.createEJBContainer();
		ctx = ejbContainer.getContext();

	}

	public static void stopContainer() throws Exception {
		ejbContainer.close();
	}

	@Before
	public void setUp() throws ParseException, NamingException {
		ctx.bind("inject", this);
		entityManager = Persistence.createEntityManagerFactory("epmteacher-pu")
				.createEntityManager();
		validStudent = new Student();
		validStudent.setLastName(validLastName);
		validStudent.setFirstName(validFirstName);
		validStudent.setPatronymic(validPatronymic);
		validStudent.setBirthday(sdf.parse(validBirthday));
	}

	@Test
	public void testSave() throws NotSupportedException, SystemException {
		userTransaction.begin();
		studentBean.setEntityManager(entityManager);
		Student result = studentBean.save(validStudent);
		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), any(Long.class));
		userTransaction.rollback();
	}
}
