package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert")
public class InsertData extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		try {
			Connection con = DatabaseConnection.initDatabase();
			PreparedStatement st = con.prepareStatement("insert into tbl_users values(?,?,?,?)");
			
			st.setInt(1, Integer.valueOf(req.getParameter("uid")));
			st.setString(2, req.getParameter("fname"));
			st.setString(3, req.getParameter("lname"));
			st.setInt(4, Integer.valueOf(req.getParameter("age")));
			
			st.executeQuery();
			
			st.close();
			con.close();
			PrintWriter pw = res.getWriter();
			
			pw.println("<html><body><b>Successfully Inserted" + "</b></body></html>");		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
					
}

