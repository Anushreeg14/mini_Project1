package com.log.lohin2;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;

public class EmployeeDetails {
	
	public static Employee getEmployee(String name,String pswd)
	{
		Employee emp=null;
	Connection con=Valiadation.getCon();
try {
	
	PreparedStatement p1=	con.prepareStatement("select * from details where username=? and password=?");
	p1.setString(1, name);
	p1.setString(2, pswd);
	ResultSet rs=p1.executeQuery();
	rs.next();
	int eid=rs.getInt("id");
	String ename=rs.getString("name");
	int salary =rs.getInt("salary");
	String domain=rs.getString("domain");
	 emp=new Employee(eid,ename,salary,domain);
	
	
} catch (SQLException e) {
	
	e.printStackTrace();
}
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return emp;
		

}
	
}