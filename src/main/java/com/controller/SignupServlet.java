package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;
import com.util.Validator;

public class SignupServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserBean user = new UserBean();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		
		boolean isError = false;
		if (Validator.isBlank(firstName) == true) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter First Name");
		} else if (Validator.isAlpha(firstName) == false) {
			isError = true;
			request.setAttribute("firstNameError", "Please Enter Valid First Name");
		}

		if (Validator.isBlank(lastName)) {
			isError = true;
			request.setAttribute("lastNameError", "Please Enter Last Name");
		} else if (Validator.isAlpha(lastName) == false) {
			isError = true;
			request.setAttribute("lastNameError", "Please Enter Valid Last Name");
		}

		if (Validator.isBlank(email)) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		}

		if (Validator.isBlank(password)) {
			isError = true;
			request.setAttribute("passwordError", "Please Enter Password");
		}

		// db connection

		// insert

		if (isError == true) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("Signup.jsp").forward(request, response);
		} else {

			

			UserDao userDao = new UserDao();
			userDao.addUser(user);

			response.sendRedirect("Login.jsp");
		}
	}// MVC -> model view controller

}
