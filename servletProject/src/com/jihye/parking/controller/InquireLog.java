package com.jihye.parking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;
import com.jihye.parking.model.Ldto;

/**
 * Servlet implementation class Inquire2
 */
@WebServlet("/inquirelog")
public class InquireLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String carNum = req.getParameter("carNum");

		ArrayList<Ldto> logs = Ldao.selectLog(carNum);

		for (Ldto temp : logs) {
			System.out.println("log조회 " + temp.getCarNum());
			System.out.println("log조회 " + temp.getTimeIn());
			System.out.println("log조회 " + temp.getTimeOut());
		}

		req.setAttribute("logs", logs);
		RequestDispatcher dp = req.getRequestDispatcher("inquire.jsp");
		dp.forward(req, res);
	}

}
