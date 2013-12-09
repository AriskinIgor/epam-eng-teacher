package com.epam.mentoring.engteacher.validators;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJBException;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import com.epam.mentoring.engteacher.persistence.model.Student;

public class StudentValidatorTest {

	private static EJBContainer ejbContainer;

	private static Context ctx;

	private StudentValidator studentValidator;

	private Student unvalidStudent;

	private static final String unvalidFirstName = "Петр1";

	private static final String unvalidLastName = "2Иванов";

	private static final String unvalidPatronymic = "Сидо2ров";

	private static final String unvalidBirthday = "06.01.1812";

	private Student validStudent;

	private static final String validFirstName = "Петр";

	private static final String validLastName = "Иванов";

	private static final String validPatronymic = "Сидоров";

	private static final String validBirthday = "06.01.1991";

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@BeforeClass
	public static void startEJBContainer() throws NamingException {
		Map<String, File[]> properties = new HashMap<String, File[]>();
		properties.put(EJBContainer.MODULES, new File[] { new File(
				"target/classes") });
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
		// Check JNDI dependencies
		assertNotNull(ctx
				.lookup("java:global/eng-teacher-web/StudentValidator"));
	}

	@AfterClass
	public static void closeContainer() throws Exception {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void setUp() throws ParseException, NamingException {
		// Looks up for the EJB
		studentValidator = (StudentValidator) ctx
				.lookup("java:global/eng-teacher-web/StudentValidator");
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		validStudent = new Student();
		validStudent.setLastName(validLastName);
		validStudent.setFirstName(validFirstName);
		validStudent.setPatronymic(validPatronymic);
		validStudent.setBirthday(sdf.parse(validBirthday));
	}

	@Test
	public void testValidate() {
		boolean result = studentValidator.validate(validStudent);
		assertTrue(result);
	}

	@Test
	public void testBirthdayCheck() {
		boolean result = studentValidator.birthdayCheck(validStudent
				.getBirthday());
		assertTrue(result);
	}

	@Test
	public void testCheckWithRegExp() {
		boolean result = studentValidator.checkWithRegExp(validStudent
				.getFirstName());
		assertTrue(result);
	}

	@Test
	public void testLengthCheck() {
		boolean result = studentValidator.lengthCheck(validStudent
				.getFirstName());
		assertTrue(result);
	}

	@Test
	public void testUsingTempFolder() throws IOException {
		File createdFolder = folder.newFolder("newfolder");
		File createdFile = folder.newFile("myfilefile.txt");
		assertTrue(createdFolder.exists());
		assertTrue(createdFile.exists());
	}

	@Test
	public void throwsIllegalArgumentExceptionIfIconIsNull() {
		exception.expect(EJBException.class);
		studentValidator.birthdayCheck(null);
	}

}
