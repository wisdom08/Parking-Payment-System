package com.jihye.parking.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;
import com.jihye.parking.model.Mdao;

@WebServlet("/park")
public class Park extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String carNum = req.getParameter("carNum");

		System.out.println("carNum:::" + carNum);

		// 차 번호 있는지 없는지 체크해보자.

		try {
			if (Mdao.isGuest(carNum)) {
				// 게스트다
				boolean guestresult = Mdao.insertGuest(carNum);
				System.out.println("guestresult::::::" + guestresult);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean LdaoResult = Ldao.insert(carNum);
		System.out.println("LdaoResult::::::" + LdaoResult);

		res.sendRedirect("/");

	}
}
