package com.jihye.parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
		String type = req.getParameter("type");

		System.out.println("jsp에서 넘어온 name::::::::::" + name);
		System.out.println("jsp에서 넘어온 carNum::::::::::" + carNum);
		System.out.println("jsp에서 넘어온 stype::::::::::" + type);

		if (name.length() == 0 || carNum == null) {
			System.out.println("이름이 없다.");

			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('이름을 입력해주세요.');");
			out.print("history.back();");
			out.print("</script>");
		} else if (carNum.length() == 0 || carNum == null) {
			System.out.println("차번호가 없다.");

			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('차 번호를 입력해주세요.');");
			out.print("history.back();");
			out.print("</script>");
		} else if (type == null) {
			System.out.println("회원 타입이 없다.");
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('회원 타입을 선택해주세요.');");
			out.print("history.back();");
			out.print("</script>");

		} else {
			System.out.println("회원 등록 완료");
			boolean MdaoResult = Mdao.insert(name, carNum, type);
			System.out.println("name:::::" + name);
			System.out.println("carNum:::::" + carNum);
			System.out.println("type:::::" + type);
			System.out.println("MdaoResult:::::" + MdaoResult);

			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('회원 등록 완료');");
			out.print("location.href = '/';");
			out.print("</script>");

			// res.sendRedirect("/");
		}

	}
}
