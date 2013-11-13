package com.epam.mentoring.engteacher.springmvc.controllers;

import javax.servlet.AsyncContext;

public interface AsyncBeanI {

	public void executeLongTask(AsyncContext asyncContext);
}
