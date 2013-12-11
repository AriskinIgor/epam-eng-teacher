package com.epam.mentoring.engteacher.validators;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateValidator {

	private int minAge = 18;

	private int maxAge = 200;

	public DateValidator(int minAge, int maxAge) {
		this.maxAge = maxAge;
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public boolean birthdayCheck(Date birthday) {
		if (birthday == null)
			throw new IllegalArgumentException();
		Calendar currentCalendar = GregorianCalendar.getInstance();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(birthday);
		if ((currentCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) > maxAge
				|| (currentCalendar.get(Calendar.YEAR) - calendar
						.get(Calendar.YEAR)) < minAge) {
			return false;
		}
		return true;
	}
}
