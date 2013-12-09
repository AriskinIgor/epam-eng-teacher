package com.epam.mentoring.engteacher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.epam.mentoring.engteacher.controllers.ControllersITest;
import com.epam.mentoring.engteacher.controllers.StudentBeanITest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ StudentBeanITest.class, ControllersITest.class,  })
public class AllITest {

}
