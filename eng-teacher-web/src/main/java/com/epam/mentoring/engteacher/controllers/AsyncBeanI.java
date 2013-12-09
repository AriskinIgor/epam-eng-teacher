package com.epam.mentoring.engteacher.controllers;

import javax.servlet.AsyncContext;

public interface AsyncBeanI {

	public void executeLongTask(AsyncContext asyncContext);
}
