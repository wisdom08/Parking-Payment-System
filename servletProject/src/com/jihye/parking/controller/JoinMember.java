package com.jihye.parking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Mdao;

@WebServlet("/joinmember")
public class JoinMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String carNum = req.getParameter("carNum");
		String stype = req.getParameter("type");
		int type = Integer.parseInt(stype);

		boolean MdaoResult = Mdao.insert(name, carNum, type);
		System.out.println("name:::::" + name);
		System.out.println("carNum:::::" + carNum);
		System.out.println("type:::::" + type);
		System.out.println("MdaoResult:::::" + MdaoResult);

		res.sendRedirect("/");

	}
}
