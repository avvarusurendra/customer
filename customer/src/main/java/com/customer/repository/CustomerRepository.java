package com.customer.repository;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.customer.model.Customer;

@Repository
public class CustomerRepository {
	int value = 0;
  public int saveCustomer(@RequestBody Customer customer) {
	  try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customer", "root", "root");
		PreparedStatement preparedStatement = connection.prepareStatement("insert into customerdata values (?,?,?);");
		preparedStatement.setInt(1, customer.getcId());
		preparedStatement.setString(2, customer.getcName());
		preparedStatement.setInt(3, customer.getcAge());
		value= preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return value;
  }
}
