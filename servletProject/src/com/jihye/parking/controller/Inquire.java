package com.jihye.parking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;

@WebServlet("/inquire")
public class Inquire extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("jssp에서 넘어온 " + req.getParameter("carNum"));
		String carNum = req.getParameter("carNum");

		boolean update = Ldao.update(carNum);
		System.out.println("update----->" + update);

		RequestDispatcher rd = req.getRequestDispatcher("/inquirelog");
		rd.forward(req, res);

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
