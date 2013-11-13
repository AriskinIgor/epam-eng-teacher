package com.epam.mentoring.engteacher.springmvc.controllers;

import javax.servlet.AsyncContext;

public interface TestAsyncStatelessSessionBeanI {

	public void executeLongTask(AsyncContext asyncContext);
}
