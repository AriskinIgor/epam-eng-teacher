package com.epam.mentoring.engteacher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.epam.mentoring.engteacher.controllers.ControllersTest;
import com.epam.mentoring.engteacher.controllers.admin.AdminControllerTest;
import com.epam.mentoring.engteacher.validators.StudentValidatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ StudentValidatorTest.class, ControllersTest.class,
		AdminControllerTest.class })
public class AllTest {

}
