package com.epam.mentoring.engteacher.springmvc.controllers;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.servlet.AsyncContext;

import org.apache.log4j.Logger;

@Stateless
public class AsyncBean {
	private Logger logger = Logger.getLogger(AsyncBean.class.getName());

	@Asynchronous
	public void executeLongTask(AsyncContext asyncContext) {
		String data = "";
		try {
			for (int i = 0; i < 10; i++) {
				String threadName = Thread.currentThread().getName();
				logger.info(i + "\t EJB3 executeLongTask(asyncContext) at "
						+ new java.util.Date() + "\t" + threadName);
				Thread.sleep(2000);
				data = data + "\n" + i
						+ "\t EJB3 executeLongTask(asyncContext) at "
						+ new java.util.Date() + "\t" + threadName;
			}
			logger.info("[EJB Processing is done] : " + data);
			asyncContext.complete();
			System.out.println("Test commit");
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
	}
}
