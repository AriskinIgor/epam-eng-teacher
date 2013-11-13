package com.epam.mentoring.engteacher.springmvc.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(value = "/TestAsyncServletURL", asyncSupported = true)
public class TestAsyncServlet extends HttpServlet {

	private static final long serialVersionUID = 8285692532155178830L;

	@EJB(lookup = "java:module/AsyncBean!com.epam.mentoring.engteacher.springmvc.controllers.AsyncBean")
	AsyncBean asyncBean;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger logger = Logger.getLogger(TestAsyncServlet.class.getName());
		PrintWriter out = response.getWriter();

		logger.info("TestAsyncServlet inside service(req,res)");
		logger.info("TestAsyncServlet inside ThreadName : "
				+ Thread.currentThread().getName());

		// Calling startAsync() method on servlet indicates that we are
		// associating request in Async Mode
		AsyncContext asyncContext = request.startAsync();

		// Here the main execution of the following EJB method will run in a
		// separate thread
		asyncBean.executeLongTask(asyncContext);
		for (int i = 0; i < 10; i++) {
			String threadName = Thread.currentThread().getName();
			logger.info("\tTestAsyncServlet service() at "
					+ new java.util.Date() + "\t" + threadName);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.println("ServletRequest is Processed ... !!!<font color=red>But EJB still might be processing</font>");
		out.close();
	}
}
