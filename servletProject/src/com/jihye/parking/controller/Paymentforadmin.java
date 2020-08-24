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

import com.jihye.parking.model.Pdao;
import com.jihye.parking.model.Pdto;

/**
 * Servlet implementation class Welcomeadmin
 */
@WebServlet("/paymentforadmin")
public class Paymentforadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {

			List<Pdto> Plist = Pdao.selectMember();

			req.setAttribute("plist", Plist);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dp = req.getRequestDispatcher("paymentforadmin.jsp");
		dp.forward(req, res);

	}

}
