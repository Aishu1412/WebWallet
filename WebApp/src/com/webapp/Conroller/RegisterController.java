package com.webapp.Conroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.RegisterDao;
import com.webapp.web.RegisterWeb;




/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private RegisterDao registerDao=new RegisterDao();
	
	public void init() {
		registerDao=new RegisterDao();
	}   
    /**
     * @see HttpServlet#HttpServlet()
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("register/register.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		register1(request, response);
	}
	private void register1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String full_name=request.getParameter("full_name");
		 String gender=request.getParameter("gender");
		 String dob=request.getParameter("dob");
		 String aadhar_number=request.getParameter("aadhar_number");
		 String mobile_number=request.getParameter("mobile_number");
		 String email_id=request.getParameter("email_id");
		 String address=request.getParameter("address");
		 String vehicle_number=request.getParameter("vehicle_number");
		 String vin=request.getParameter("vin");
		 String vehcile_class=request.getParameter("vehcile_class");
		 String fuel=request.getParameter("fuel");
		 String register_authority=request.getParameter("register_authority");
		 String insurance_upto=request.getParameter("insurance_upto");
		 String fitness_regn_upto=request.getParameter("fitness_regn_upto");
		
		RegisterWeb register = new RegisterWeb();
		
		register.setFull_name(full_name);
		register.setGender(gender);
		register.setDob(dob);
		register.setAadhar_number(aadhar_number);
		register.setMobile_number(mobile_number);
		register.setEmail_id(email_id);
		register.setAddress(address);
		register.setVehicle_number(vehicle_number);
		register.setVin(vin);
		register.setVehcile_class(vehcile_class);
		register.setFuel(fuel);
		register.setRegister_authority(register_authority);
		register.setInsurance_upto(insurance_upto);
		register.setFitness_regn_upto(fitness_regn_upto);
	
		
		try {
			int result = registerDao.registerQR(register);
			if(result == 1) {
				request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
	}

	}


