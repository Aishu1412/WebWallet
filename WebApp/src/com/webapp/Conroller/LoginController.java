package com.webapp.Conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.webapp.dao.LoginDao;
import com.webapp.web.LoginWeb;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
		loginDao = new LoginDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		authenticate(request, response);
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginWeb loginweb = new LoginWeb();
		loginweb.setUsername(username);
		loginweb.setPassword(password);

		try {
			if (loginDao.validate(loginweb)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("common/success.jsp");
				dispatcher.forward(request, response);
			} else {
				System.out.println(" Incorrect Details");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}


