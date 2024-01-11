package com.kn.login2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.log.lohin2.Valiadation;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection con=Valiadation.getCon();
 try {
	 String salary=req.getParameter("salary");
	 int sal=Integer.parseInt(salary);
	PreparedStatement p2=	con.prepareStatement("insert into details(name,salary,domain,username,password) values(?,?,?,?,?)");
	p2.setString(1, req.getParameter("name"));
	p2.setInt(2, sal);
	p2.setString(3, req.getParameter("domain"));
	p2.setString(4, req.getParameter("username"));
	p2.setString(5, req.getParameter("password"));
	p2.execute();
	resp.sendRedirect("login.html");
} catch (SQLException e) {
	e.printStackTrace();
}
 try {
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
