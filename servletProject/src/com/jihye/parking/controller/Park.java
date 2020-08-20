package com.jihye.parking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;

@WebServlet("/park")
public class Park extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String method = req.getMethod();
		System.out.println("method:::::" + method);

		req.setCharacterEncoding("utf-8");

		String carNum = req.getParameter("carNum");

		System.out.println("carNum:::" + carNum);
		System.out.println("test:::");

		boolean LdaoResult = Ldao.insert(carNum);
		System.out.println("LdaoResult::::::" + LdaoResult);

		res.sendRedirect("/");

	}
}
