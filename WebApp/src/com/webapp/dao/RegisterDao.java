package com.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webapp.web.RegisterWeb;

import JBDCutils.JBDCUtils;


public class RegisterDao {
   public int registerQR(RegisterWeb registerweb)throws ClassNotFoundException {
	   String sql="INSERT INTO qrregistration "
		   		+ "(full_name, gender, dob, aadhar_number, mobile_number, email_id, address, vehicle_number,"
		   		+ " vin, vehcile_class, fuel, register_authority, insurance_upto, fitness_regn_upto)"
		   		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	   int result=0;

	   Class.forName("com.mysql.cj.jdbc.Driver");
	   try(Connection connection = JBDCUtils.getConnection();
			   
			   PreparedStatement ps = connection.prepareStatement(sql)){
		   ps.setString(1, registerweb.getFull_name());
		   ps.setString(2, registerweb.getGender());
		   ps.setString(3, registerweb.getDob());
		   ps.setString(4, registerweb.getAadhar_number());
		   ps.setString(5, registerweb.getMobile_number());
		   ps.setString(6, registerweb.getEmail_id());
		   ps.setString(7, registerweb.getAddress());
		   ps.setString(8, registerweb.getVehicle_number());
		   ps.setString(9, registerweb.getVin());
		   ps.setString(10, registerweb.getVehcile_class());
		   ps.setString(11, registerweb.getFuel());
		   ps.setString(12, registerweb.getRegister_authority());
		   ps.setString(13, registerweb.getInsurance_upto());
		   ps.setString(14, registerweb.getFitness_regn_upto());
		  
	System.out.println(ps);
	result=ps.executeUpdate();
		   
		   
		   
 

   }catch(SQLException e) {
	   JBDCUtils.printSQLException(e);   }
	   return result;
}
}

