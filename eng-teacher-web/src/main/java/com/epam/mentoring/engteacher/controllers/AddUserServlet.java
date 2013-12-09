package com.epam.mentoring.engteacher.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mentoring.engteacher.persistence.model.Student;

@javax.servlet.annotation.WebServlet(urlPatterns = "/addUser")
public class AddUserServlet extends HttpServlet {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8076731708455380743L;

	@EJB
	private StudentBean bean;

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		Student stud = new Student();
		stud.setFirstName(name);
		bean.create(stud);
		out.println("Created and persisted " + stud);

		Student s = bean.getStudentByName(name);
		out.println("Query returned: " + s);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
