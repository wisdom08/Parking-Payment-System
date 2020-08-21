package com.jihye.parking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;
import com.jihye.parking.model.Ldto;
import com.jihye.parking.model.Mdao;
import com.jihye.parking.model.Pdao;
import com.jihye.parking.model.Pdto;

@WebServlet("/inquire")
public class Inquire extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("jssp에서 넘어온 " + req.getParameter("carNum"));
		String carNum = req.getParameter("carNum");

		boolean update = false;
		try {
			update = Ldao.update(carNum);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("update----->" + update);

		ArrayList<Ldto> logs = Ldao.selectLog(carNum);

		for (Ldto temp : logs) {
			System.out.println("log조회 " + temp.getCarNum());
			System.out.println("log조회 " + temp.getTimeIn());
			System.out.println("log조회 " + temp.getTimeOut());
		}

		String type = null;

		try {
			type = Mdao.select(carNum);
		} catch (SQLException e) {
			e.printStackTrace();

		}

		Pdao.updateAmount(carNum, type);

		ArrayList<Pdto> plist = Pdao.select(carNum);

		req.setAttribute("type", type);
		req.setAttribute("plist", plist);
		req.setAttribute("logs", logs);
		RequestDispatcher dp = req.getRequestDispatcher("inquire.jsp");
		dp.forward(req, res);

		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("/inquirelog");
		 * rd.forward(req, res);
		 */

//		res.setContentType("text/html; charset = utf-8");
//		PrintWriter out = res.getWriter();
//		res.addHeader("Refresh", "5; url = inquirelog");
//		res.sendRedirect("/inquirelog");

		/*
		 * boolean timeoutUpdate = Ldao.update(carNum);
		 * System.out.println("timeoutUpdate::::" + timeoutUpdate);
		 */

	}
}
