package com.jihye.parking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;
import com.jihye.parking.model.Ldto;

/**
 * Servlet implementation class Welcomeadmin
 */
@WebServlet("/logforadmin")
public class Logforadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			List<Ldto> llist = Ldao.selectforadmin();
			req.setAttribute("llist", llist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dp = req.getRequestDispatcher("logforadmin.jsp");
		dp.forward(req, res);

	}

}
