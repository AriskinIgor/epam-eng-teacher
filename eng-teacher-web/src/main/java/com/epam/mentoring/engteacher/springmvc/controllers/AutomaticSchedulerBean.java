package com.epam.mentoring.engteacher.springmvc.controllers;

import javax.ejb.Stateless;
import java.util.Date;
import javax.ejb.Schedule;

import org.apache.log4j.Logger;

@Stateless(name = "AutomaticSchedulerBean")
public class AutomaticSchedulerBean {

	private static final Logger log = Logger.getRootLogger();

	@Schedule(dayOfWeek = "*", hour = "*", minute = "*", second = "*/5", year = "2013", persistent = false)
	public void backgroundProcessing() {

		log.info("Run servlet");

		System.out
				.println("\n\n\t AutomaticSchedulerBean's backgroundProcessing() called at: "
						+ new Date());
	}

}
