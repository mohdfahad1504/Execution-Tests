package com.tyss.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.Pool.ConnectionPool;

@WebServlet("/addstudent")
public class AddStudent extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String sid = req.getParameter("sid");
		 int id = Integer.parseInt(sid);
		 String name = req.getParameter("sname");
		 String email = req.getParameter("semail");
		 String sphone = req.getParameter("sphone");
		 long phone = Long.parseLong(sphone);
		 String std = req.getParameter("sstd");
		 String address = req.getParameter("sadd");
		 
		 Connection con = ConnectionPool.giveConnection();
		 
		 try {
			 String insert = "INSERT INTO students VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement stm = con.prepareStatement(insert);
			stm.setInt(1, id);
			stm.setString(2, name);
			stm.setString(3, email);
			stm.setLong(4, phone);
			stm.setString(5, std);
			stm.setString(6, address);
			
			stm.executeUpdate();
			
			ConnectionPool.submitConnection(con);
			
			RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
			req.setAttribute("success", "Student Added");
			rd.forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
			req.setAttribute("error", "Already Added");
			rd.forward(req, resp);
		}
	}

}
