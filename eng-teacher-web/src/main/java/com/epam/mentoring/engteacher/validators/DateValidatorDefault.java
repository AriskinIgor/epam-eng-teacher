package com.epam.mentoring.engteacher.validators;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateValidatorDefault {
	
	public static boolean birthdayCheck(Date birthday) {
		if (birthday == null)
			throw new IllegalArgumentException();
		Calendar currentCalendar = GregorianCalendar.getInstance();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(birthday);
		if ((currentCalendar.get(Calendar.YEAR) - calendar.get(Calendar.YEAR)) > 200
				|| (currentCalendar.get(Calendar.YEAR) - calendar
						.get(Calendar.YEAR)) < 18) {
			return false;
		}
		return true;
	}
}
