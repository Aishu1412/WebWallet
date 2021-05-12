package com.webapp.Conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.SignUpDao;
import com.webapp.web.SignUpWeb;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
private static final long serialVersionUID = 1L;
	private SignUpDao signupDao;

	public void init() {
		signupDao = new SignUpDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("signup/signup.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		SignUpWeb signup = new SignUpWeb();
		signup.setFirstName(firstName);
		signup.setLastName(lastName);
		signup.setUsername(username);
		signup.setPassword(password);

		try {
			int result = signupDao.registerEmployee(signup);
			if(result == 1) {
				request.setAttribute("NOTIFICATION", "User Signed Up Successfully!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("signup/signup.jsp");
		dispatcher.forward(request, response);
	}
}
