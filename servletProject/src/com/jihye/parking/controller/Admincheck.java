package com.jihye.parking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/admincheck")
public class Admincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = "adminadmin";
		String pw = "1234";

		String uid = req.getParameter("id");
		String upw = req.getParameter("pw");

		System.out.println("uid" + uid);
		System.out.println("upw" + upw);

		if (id.equals(uid) && pw.equals(upw)) {
			System.out.println("굿굿 관리자 맞다");
			req.setAttribute("result", "good");
		} else {
			System.out.println("관리자 아니다");
			req.setAttribute("result", "bad");
		}

		RequestDispatcher dp = req.getRequestDispatcher("admincheck.jsp");
		dp.forward(req, res);

	}
}
