package com.log.lohin2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Valiadation
 */
@WebServlet("/Valiadation")
public class Valiadation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static Connection getCon()
	{
		String url="jdbc:mysql://localhost:3306/user";
		String username="root";
		String pwd="root";
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, pwd);
			
		}
		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("pswd");
		Connection con=getCon();

		try {
			
			PreparedStatement pstmt=con.prepareStatement("select * from details where username=? and password=?");
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet res=pstmt.executeQuery();//select * from details where username='raju' and password='123';
			resp.setContentType("text/html");
			 PrintWriter out=resp.getWriter();
			if(res.next()==true) {
				RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
				rd.forward(req, resp);
				
			}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("invalid.html");
				rd.forward(req, resp);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
