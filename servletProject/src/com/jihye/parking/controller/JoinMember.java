package com.jihye.parking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
		String position = req.getParameter("position");

		req.setAttribute("carNum", carNum);
		req.setAttribute("name", name);
		req.setAttribute("type", type);

		System.out.println("jsp에서 넘어온 name::::::::::" + name);
		System.out.println("jsp에서 넘어온 carNum::::::::::" + carNum);
		System.out.println("jsp에서 넘어온 type::::::::::" + type);

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

		} else if (type == "1" && position == null) {

			// position = "coupon";

			// req.setAttribute("position", position);
			// System.out.println("jsp에서 넘어온 position::::::::::" + position);
			position = "nochoice";
			System.out.println("직책 없다.");
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('직책을 선택해주세요. ');");
			out.print("history.back();");
			out.print("</script>");

		} /*
			 * else if (type == "2") {
			 * 
			 * position = "coupon";
			 * 
			 * req.setAttribute("position", position);
			 * System.out.println("jsp에서 넘어온 position::::::::::" + position);
			 * 
			 * System.out.println("쿠폰이용자"); res.setContentType("text/html;charset=utf-8");
			 * PrintWriter out = res.getWriter();
			 * out.print("<script type='text/javascript'>"); out.print("alert('쿠폰이용자');");
			 * out.print("</script>");
			 * 
			 * }
			 */ else {

			try {
				String isMember = Mdao.select(carNum);

				System.out.println("이미 회원인지 체크를 하자:::::" + isMember);

				if (isMember.contains("1") || isMember.contains("2")) {
					System.out.println("이미 회원이다.");
					res.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					out.print("<script type='text/javascript'>");
					out.print("alert('이미 회원 등록되어있습니다.');");
					out.print("location.href = '/';");
					out.print("</script>");

				} else {

					System.out.println("position::::" + position);
					if (position == null) {
						position = "coupon";
						System.out.println("position::::" + position);
					}

					if (position.contains("1")) {
						System.out.println("교수 선택");
						req.setAttribute("position", "1");
						req.setAttribute("price", 10000);
					} else if (position.contains("2")) {
						System.out.println("강사 선택");
						req.setAttribute("position", "2");
						req.setAttribute("price", 40000);
					} else if (position.contains("3")) {
						System.out.println("박사 선택");
						req.setAttribute("position", "3");
						req.setAttribute("price", 80000);
					} else if (position.contains("4")) {
						System.out.println("상시근무자 선택");
						req.setAttribute("position", "4");
						req.setAttribute("price", 120000);
					} else {
						System.out.println("쿠폰이용자 등록");
						req.setAttribute("position", "coupon");
						req.setAttribute("price", 10000);
					}

					req.setAttribute("position", position);
					System.out.println("jsp에서 넘어온 position::::::::::" + position);

					RequestDispatcher dp = req.getRequestDispatcher("/mpayment.jsp");
					dp.forward(req, res);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}
}
