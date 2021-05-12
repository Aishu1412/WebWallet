package com.webapp.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.webapp.web.SignUpWeb;

import JBDCutils.JBDCUtils;

public class SignUpDao {

		public int registerEmployee(SignUpWeb signup) throws ClassNotFoundException {
			String INSERT_USERS_SQL = "INSERT INTO users"
					+ "  (first_name, last_name, username, password) VALUES "
					+ " (?, ?, ?, ?);";

			int result = 0;
			try (Connection connection = JBDCUtils.getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
				preparedStatement.setString(1, signup.getFirstName());
				preparedStatement.setString(2, signup.getLastName());
				preparedStatement.setString(3, signup.getUsername());
				preparedStatement.setString(4, signup.getPassword());

				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				result = preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// process sql exception
				JBDCUtils.printSQLException(e);
			}
			return result;
		}

	}