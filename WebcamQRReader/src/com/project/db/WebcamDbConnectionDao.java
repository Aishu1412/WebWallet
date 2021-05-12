package com.project.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class WebcamDbConnectionDao {

	static Connection connection;
		
		private WebcamDbConnectionDao() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet","root","root");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){
			if (connection == null) {
				new WebcamDbConnectionDao();
			}
			return connection;
		}
		
		public static void closeConnection() {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

