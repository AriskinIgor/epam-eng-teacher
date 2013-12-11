package com.epam.mentoring.engteacher.validators;

import static com.epam.mentoring.engteacher.validators.DateValidatorDefault.birthdayCheck;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateValidatorDefaultTest {


	private static final String validBirthday = "06.01.1991";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void throwsIllegalArgumentExceptionIfIconIsNull() {
		exception.expect(IllegalArgumentException.class);
		birthdayCheck(null);
	}

	@Test
	public void testBirthdayCheck() throws ParseException {
		boolean result = birthdayCheck(sdf.parse(validBirthday));
		assertTrue(result);
	}

}
