package com.epam.mentoring.engteacher.springmvc.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.myproject.TestLibrary;

public class Controller extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1032455838821512650L;

	private static final Logger log = Logger.getLogger(Controller.class);

	static String PAGE_HEADER = "<html><head /><body>";

	static String PAGE_FOOTER = "</body></html>";

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		log.info("Run servlet");

		// Test shared library.
		TestLibrary.testLib();

		PrintWriter writer = resp.getWriter();

		writer.println(PAGE_HEADER);

		writer.println("<h1>Hello</h1>");

		writer.println(PAGE_FOOTER);

		writer.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}