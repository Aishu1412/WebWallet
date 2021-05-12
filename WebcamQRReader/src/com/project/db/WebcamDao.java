package com.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.Web.WebcamTransaction;
import com.project.Web.WebcamWallet;
import com.project.Web.WebcamUser;



public class WebcamDao {
   public boolean validate(WebcamUser webcam1) throws ClassNotFoundException{
	boolean status=false;
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	System.out.println("validate verified");
	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet","root","root");
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from user where qrid = ? ")) {
		System.out.println("validate verified");
		preparedStatement.setString(1, webcam1.getQrid());
		

		
		ResultSet rs = preparedStatement.executeQuery();
		
		status = rs.next();
   }catch (SQLException e) {
	e.printStackTrace();
  }
	return status;
 }

public static WebcamWallet getUserWalletBalance(String qrid) {
	String query = "SELECT id,cash,uid from wallet where uid=?";// TODO Auto-generated method stub
	
	PreparedStatement ps = null;

	Connection conn =WebcamDbConnectionDao.getConnection();

	try {
		ps = conn.prepareStatement(query);
		ps.setString(1, qrid);
		ResultSet rs =ps.executeQuery();
		WebcamWallet wallet = new WebcamWallet();
		while (rs.next()) {
			wallet.setId(rs.getInt(1));
			wallet.setCash(rs.getDouble(2));
			wallet.setUid(rs.getString(3));
			
		}
		return wallet;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return null;
}

public static WebcamWallet updateUserWalletBalance(String qrid, double cash) {
	
	

		WebcamWallet uWallet = getUserWalletBalance(qrid);
		
		String query = "UPDATE wallet SET cash=? where uid=?";

		Connection conn = WebcamDbConnectionDao.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, cash);
			ps.setString(2, qrid);
			int rs = ps.executeUpdate();
			if (rs==1) {
				uWallet.setCash(cash);
				System.out.println("User wallet updated.");
				return uWallet;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;// TODO Auto-generated method stub
}

public static boolean doTransaction(WebcamTransaction trans) {
	
	String query = "INSERT INTO transactions(amount,comments,user) VALUES(?,?,?)";
	Connection conn = WebcamDbConnectionDao.getConnection();
	
	try {
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setDouble(1, 50);
		ps.setString(2, "prefare deduction");
		ps.setString(3, trans.getUser());
		int rs = ps.executeUpdate();
		if (rs==1) {
			System.out.println("User has done a transaction.");
			return true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	}
	
	return false;

	
}

public static List<WebcamTransaction> getTransactions(int number, WebcamUser user) {
	String query = "SELECT * FROM transactions where user=? order by time desc limit ?";
	
	List<WebcamTransaction> transactions = new ArrayList<WebcamTransaction>();

	PreparedStatement ps = null;
	
	WebcamTransaction transaction = null;

	Connection conn = WebcamDbConnectionDao.getConnection();
	try {
		ps = conn.prepareStatement(query);
		ps.setString(1, user.getQrid());
		ps.setInt(2, number);
		
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			transaction = new WebcamTransaction(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getDate(4), rs.getString(5));
			transactions.add(transaction);
		}
		return transactions;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}// TODO Auto-generated method stub
	
public WebcamUser getUserById(String userId) {
	String query = "SELECT username,email,qrid,password from user where qrid=?";

	PreparedStatement ps = null;

	Connection conn = WebcamDbConnectionDao.getConnection();
	try {
		ps = conn.prepareStatement(query);
		ps.setString(1, userId);
		ResultSet rs = ps.executeQuery();
		WebcamUser user = new WebcamUser();
		while (rs.next()) {
			user.setQrid(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setPassword(rs.getString(4));
		}
		return user;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}




public static WebcamUser verify(String qrid) {
	String query = "SELECT qrid,username,email,password from user where qrid=? ";

	PreparedStatement ps = null;

	Connection conn = WebcamDbConnectionDao.getConnection();
	try {
		ps = conn.prepareStatement(query);
		ps.setString(1, qrid);
		
		ResultSet rs = ps.executeQuery();
		WebcamUser user = new WebcamUser();
		while (rs.next()) {
			user.setQrid(rs.getString(1));
			user.setUsername(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setPassword(rs.getString(4));
		}
		return user;
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
// TODO Auto-generated method stub
	
}}