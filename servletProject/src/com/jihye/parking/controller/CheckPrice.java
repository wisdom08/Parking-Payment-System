package com.jihye.parking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Pdao;

/**
 * Servlet implementation class CheckPrice
 */
@WebServlet("/checkPrice")
public class CheckPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());

		String uprice = req.getParameter("uprice");
		System.out.println("uprice:::::" + uprice);

		String type = req.getParameter("type");
		System.out.println("type:!!!!!!!!!!!!!!:::" + type);

		String carNum = req.getParameter("carNum");

		Pdao.update(type, carNum);

		// String price = Pdao.select();
		// System.out.println("price:::::" + price);

		res.sendRedirect("/");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}
}
