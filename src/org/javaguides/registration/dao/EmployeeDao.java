package org.javaguides.registration.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.javaguides.registration.model.Employee;



public class EmployeeDao {

	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		
		String query = "insert into tejal_madam.employee2"+ "(id,first_name,last_name,username,password,address,contact) values "+ "(?,?,?,?,?,?,?);";
		
		int result=0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		
		try {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
		
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, 1);
		preparedStatement.setString(2, employee.getFirstname());
		preparedStatement.setString(3, employee.getLastname());
		preparedStatement.setString(4, employee.getUsername());
		preparedStatement.setString(5, employee.getPassword());
		preparedStatement.setString(6, employee.getAddress());
		preparedStatement.setString(7, employee.getContact());
		
		System.out.println(preparedStatement);
		
		result = preparedStatement.executeUpdate();
		
	}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
