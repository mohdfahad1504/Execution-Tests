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

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("sid"));
		
		Connection con = ConnectionPool.giveConnection();
		
		try {
			String sql = "DELETE FROM students WHERE id=?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id);
			int res = stm.executeUpdate();
			if(res > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
				req.setAttribute("success", "Delete Successfully");
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
				req.setAttribute("error", "Not found");
				rd.forward(req, resp);
			}
			ConnectionPool.submitConnection(con);
		} catch (SQLException e) {
			RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
			req.setAttribute("error", "Not found");
			rd.forward(req, resp);
			e.printStackTrace();
		}
	}
}
