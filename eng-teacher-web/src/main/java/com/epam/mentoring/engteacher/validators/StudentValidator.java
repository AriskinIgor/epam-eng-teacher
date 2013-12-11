package com.epam.mentoring.engteacher.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.Stateless;

import com.epam.mentoring.engteacher.persistence.model.Student;

@Stateless
public class StudentValidator {

	private static final String PATTERN_NAMES = "[^0-9]*";

	public boolean validate(Student stud) {
		if (stud == null || stud.getFirstName() == null
				|| stud.getLastName() == null || stud.getFirstName().isEmpty()
				|| stud.getLastName().isEmpty() || stud.getBirthday() == null) {
			return false;
		} else if (!checkWithRegExp(stud.getLastName())
				|| !checkWithRegExp(stud.getFirstName())
				|| !lengthCheck(stud.getLastName())
				|| !lengthCheck(stud.getFirstName())) {
			return false;

		} else if (stud.getPatronymic() != null
				&& (!checkWithRegExp(stud.getPatronymic()) || !lengthCheck(stud
						.getPatronymic()))) {
			return false;
		} else if (!DateValidatorDefault.birthdayCheck(stud.getBirthday())) {
			return false;
		}
		return true;
	}

	public boolean checkWithRegExp(String str) {
		Pattern p = Pattern.compile(PATTERN_NAMES);
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public boolean lengthCheck(String str) {
		if (str.length() < 3 || str.length() > 150) {
			return false;
		}
		return true;
	}
}
