package com.epam.mentoring.engteacher.validators;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateValidatorTest {

	private static final String validBirthday = "06.01.1991";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void throwsIllegalArgumentExceptionIfIconIsNull() {
		exception.expect(IllegalArgumentException.class);
		new DateValidator(18, 200).birthdayCheck(null);
	}

	@Test
	public void testBirthdayCheck() throws ParseException {
		new MockUp<DateValidator>() {
			@Mock
			public void $init(Invocation invocation, int maxAge, int minAge) {
				DateValidator dateValidator = invocation.getInvokedInstance();
				dateValidator.setMaxAge(1);
				dateValidator.setMinAge(1);
			}
		};
		DateValidator dateValidator = new DateValidator(100, 100);
		assertThat(dateValidator.getMinAge(), is(1));
		assertThat(dateValidator.getMaxAge(), is(1));
		boolean result = dateValidator.birthdayCheck(sdf.parse(validBirthday));
		assertFalse(result);
	}
}
