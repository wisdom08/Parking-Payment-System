package com.jihye.parking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
	private static Date expDate;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String carNum = req.getParameter("carNum");

		System.out.println("carNum:::" + carNum);

		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=UTF-8");

		// Ldao.delete(carNum);

		try {
			expDate = Mdao.getExpdate(carNum);
			System.out.println("서블릿으로 넘어온 expDate:::::::" + expDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("서블릿으로 넘어온 expDate22:::::::" + expDate);

		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentTime = new Date();
		String mTime = mSimpleDateFormat.format(currentTime);
		System.out.println(mTime);

		System.out.println("날짜 출력::::::::::" + mTime);

		boolean parkCheck = Ldao.selectLogCheck(carNum);
		System.out.println("입차여부 체크!!! " + parkCheck);

		System.out.println(mTime + expDate);

		// exPdate는 date
		// mTime 은 string

		if (parkCheck) {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('이미 입차한 차량입니다. ');");
			out.print("location.href='/';");
			out.print("</script>");
			return;
		} else {
			// 입차 x

			try {
				java.util.Date d = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(mTime);

				int compare = d.compareTo(expDate);

				if (compare > 0) {
					System.out.println("d>expdate");

					Mdao.delete(carNum);
					System.out.println("기간만료 회원 삭제");

					res.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					out.print("<script type='text/javascript'>");
					out.print("alert('회원 기간 만료되었서 일반요금으로 부가됩니다.(입차 중에도 회원 등록 가능합니다.)');");
					out.print("</script>");

				} else if (compare < 0) {
					System.out.println("d<expdate");

				} else {
					System.out.println("d == expdate");

					res.setContentType("text/html;charset=utf-8");
					PrintWriter out = res.getWriter();
					out.print("<script type='text/javascript'>");
					out.print("alert('오늘은 회원 기간 만료일입니다.');");
					out.print("</script>");

				}

			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

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

			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('입차 완료');");
			out.print("location.href='/';");
			out.print("</script>");
		}

		// res.sendRedirect("/");

	}
}
