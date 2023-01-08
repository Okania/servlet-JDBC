package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import DatabaseConnection;


//@WebServlet("/insert")
public class InsertData extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		res.setContentType("text/html");
		try {
			Connection con = DatabaseConnection.initDatabase();
			PreparedStatement st = con.prepareStatement("insert into details values(?,?)");
			
//			st.setInt(1, Integer.valueOf(req.getParameter("uid")));
			st.setString(1, req.getParameter("fname"));
			st.setString(2, req.getParameter("lname"));
//			st.setInt(4, Integer.valueOf(req.getParameter("age")));
			
			st.executeUpdate();
			
			st.close();
			con.close();
			PrintWriter pw = res.getWriter();
			
			pw.println("<h1>" + "DATA INSERTED SUCCESSFULLY!" + "</h1>");		
			
		} catch(ClassNotFoundException e) {
			PrintWriter writer = res.getWriter();
			writer.println("<h1>" + "MySQL Driver class not found!" + "</h1>");
			e.printStackTrace();
			
		} catch(SQLException e) {
			PrintWriter wr = res.getWriter();
			wr.println("<h1>" + "Error while executing Query!" + "</h1>");
			e.printStackTrace();
		}
	}	
					
}

