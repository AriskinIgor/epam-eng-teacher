package com.epam.mentoring.engteacher.controllers;

import javax.ejb.Stateless;
import java.util.Date;

import javax.ejb.Schedule;

import org.apache.log4j.Logger;

@Stateless(name = "AutomaticSchedulerBean")
public class AutomaticSchedulerBean {

	private Logger logger = Logger.getLogger(AutomaticSchedulerBean.class
			.getName());

	@Schedule(dayOfWeek = "*", hour = "*", minute = "*", second = "*/5", year = "2013", persistent = false)
	public void backgroundProcessing() {

		logger.info("\n\n\t AutomaticSchedulerBean's backgroundProcessing() called at: "
				+ new Date());
	}

}
