package com.webapp.Conroller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;






/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("Admin/AdminList.jsp");
	}
	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
       try {
    	   switch(action) {
    	   case "RegistrationList":
    		   reglist(request,response);
    		   break;
    	   case "QRGenerate":
    		   qrgenerate(request,response);
    		   break;
    	   }
       }
    	   catch(Exception e) {
    		   e.printStackTrace();
    	   }
       }
    	   
       



	



	private void reglist(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qrcodeapplication","root","root");
			PreparedStatement ps = connection.prepareStatement("Select * from qrregistration");
			ResultSet rs= ps.executeQuery();
			PrintWriter out=response.getWriter();
			out.println("<html><body><table border:1 px solid black><tr><td>QR ID</td><br><td>FullName</td>"
					+ "<td>Gender</td> <td>DOB</td> <td>AadharNumber</td>"
					+ "<td>MobileNumber</td> <td>EmailID</td> <td>Address</td> <td>VehicleNumber</td>"
					+ "<td>VIN</td> <td>VehicleClass</td> <td>Fuel</td> "
					+ "<td>RegisterAuthority</td> <td>InsuranceUpto</td> <td>Fitness/RegnUpto</td>"
					+ "</tr> ");
			while(rs.next()) {
				out.println(
						"<tr><td>"+rs.getString("qr_id")+"</td>"
						+ "<td>"+rs.getString("full_name")+"</td>"
						+ "<td>"+rs.getString("gender")+"</td>"
						+ "<td>"+rs.getString("dob")+"</td>"
						+ "<td>"+rs.getString("aadhar_number")+"</td>"
						+ "<td>"+rs.getString("mobile_number")+"</td>"
						+ "<td>"+rs.getString("email_id")+"</td>"
						+ "<td>"+rs.getString("address")+"</td>"
						+ "<td>"+rs.getString("vehicle_number")+"</td>"
						+ "<td>"+rs.getString("vin")+"</td>"
						+ "<td>"+rs.getString("vehcile_class")+"</td>"
						+ "<td>"+rs.getString("fuel")+"</td>"
						+ "<td>"+rs.getString("register_authority")+"</td>"
						+ "<td>"+rs.getString("insurance_upto")+"</td>"
						+ "<td>"+rs.getString("fitness_regn_upto")+"</td>"
						+ "</tr>");
			}
			out.println("</table></body></html>");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void qrgenerate(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("Success");
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/qrcodeapplication","root","root");
		String query = "select * from qrregistration";
		Statement stmt = null;
        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
		                    
	            while (rs.next()) {
	            	
	            	try {
	            	System.out.println("Called1");
	            		String qrcodeid= rs.getString("qr_id");
	            		String vehicleownername = rs.getString("full_name");
	            		String vehiclenumber = rs.getString("vehicle_number");
	            		String registerauthority = rs.getString("register_authority");
	            		String vin = rs.getString("vin");
	            		String vehicleclass = rs.getString("vehcile_class");
	            		String fuel = rs.getString("fuel");
	            		String insurance = rs.getString("insurance_upto");
	            		String fitnessupto = rs.getString("fitness_regn_upto");
	        			String filePath = "D:\\QR ID"+ qrcodeid +".png";
	        			
	        			 Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
	                     hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	                    
	                    BitMatrix matrix = new MultiFormatWriter().encode("QR CodeID:  "+qrcodeid + "\n" 
	                    +""+ "\n"+ "Vehicle Owner:  "+vehicleownername +"\n"  
	                    +""+ "\n"+"Vehicle Number:  "+vehiclenumber + "\n" 
	                    +""+ "\n"+"Register Authority:  "+registerauthority + "\n"
	                    +""+ "\n"+"VIN:  "+vin +"\n"
	                    +""+ "\n"+"Vehicle Class:  "+vehicleclass +"\n"
	                    +""+ "\n"+"Fuel:  "+fuel +"\n"
	                    +""+ "\n"+"Insurance Upto:  "+insurance +"\n"
	                    +""+ "\n"+"Fitnes/regn Upto:  "+fitnessupto+"\n" ,
	            						BarcodeFormat.QR_CODE, 350, 350,hintMap);

	                    
	                    MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
	                        .lastIndexOf('.') + 1), new File(filePath));
	                    System.out.println("Called2");
	                   
	                } catch (Exception e) {
	                    System.err.println(e);
	                }
	                            
	                } System.out.println("QR Code image created successfully!");
			}catch (Exception e) {
	            System.err.println(e);
	        }
		}
	}
	

