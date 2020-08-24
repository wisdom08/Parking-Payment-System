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

import com.jihye.parking.model.Mdto;
import com.jihye.parking.model.MemberDBUtil;

@WebServlet("/list")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get the data from the database(model)
		/*
		 * String[] members = { "joy", "jihye", "corrine" }; req.setAttribute("members",
		 * members);
		 */

		try {
			List<Mdto> memberList = MemberDBUtil.getMemberList();
			req.setAttribute("memberList", memberList);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// redirect to a different page(view)
		RequestDispatcher dp = req.getRequestDispatcher("list.jsp");
		dp.forward(req, res);

	}
}