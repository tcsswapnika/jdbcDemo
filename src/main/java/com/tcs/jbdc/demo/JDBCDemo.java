package com.tcs.jbdc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/practice";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";

		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
			// insert(statement);
			// retrieve(statement);
			update(statement);
			// List<String> regions = retrieveWithCondition(statement, "A");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	private static List<String> retrieveWithCondition(Statement statement, String string) {
		return null;
	}

	private static void retrieve(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * from regions");
		List<String> regions = new ArrayList<String>();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getNString("REGION_NAME"));
			regions.add(resultSet.getNString("REGION_NAME"));
		}
	}

	private static void insert(Statement statement) throws SQLException {

		statement.execute("INSERT INTO REGIONS VALUES(5, 'asia')");

	}

	private static void update(Statement statement) throws SQLException {
		statement.executeUpdate("UPDATE regions set region_name = 'Antartica' where region_id = 5");
	}

}
