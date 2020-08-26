package com.jihye.parking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;
import com.jihye.parking.model.Pdao;

/**
 * Servlet implementation class CheckPrice
 */
@WebServlet("/checkprice")
public class CheckPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		String uprice = req.getParameter("uprice");
		System.out.println("입력한 uprice:::::" + uprice);
		String method = req.getParameter("method");
		System.out.println("method:!!!!!!!!!!!!!!:::" + method);
		String receipt = req.getParameter("receipt");
		System.out.println("receipt:!!!!!!!!!!!!!!:::" + receipt);

		String carNum = req.getParameter("carNum");
		String price = req.getParameter("price");
		int num = Integer.parseInt(price);

		System.out.println("payment에서 넘어온 실제 가격:::::::" + price);
		System.out.println("pyament에서 넘어온 차 번호::::" + carNum);

		if (uprice.equals(price)) {

			System.out.println("실제가격과 입력한 가격이 같다.");

			if (method == null) {

				System.out.println("method null 체크 " + method);

				res.setContentType("text/html;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('method 미체크');");
				out.print("history.back();");
				out.print("</script>");

				// res.sendRedirect("/");
			} else if (receipt == null) {
				System.out.println("recipt null 체크 " + receipt);

				res.setContentType("text/html;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('영수증 미체크');");
				out.print("history.back();");
				out.print("</script>");

			} else {
				System.out.println("결제완료");
				boolean pinsert = Pdao.insert(num, method, carNum);
				System.out.println("pinsert::::" + pinsert);

				Ldao.delete(carNum);

				res.setContentType("text/html;charset=utf-8");
				PrintWriter out = res.getWriter();
				out.print("<script type='text/javascript'>");
				out.print("alert('결제 완료');");
				out.print("location.href = '/';");
				out.print("</script>");
			}

			/*
			 * res.setContentType("text/html;charset=utf-8"); PrintWriter out =
			 * res.getWriter(); out.print("<script type='text/javascript'>");
			 * out.print("alert('success ');"); out.print("location.href='/';");
			 * out.print("</script>");
			 */

			// boolean pupdate = Pdao.update(method, carNum);
			// System.out.println("p업데이트:::::" + pupdate);

		} else {
			System.out.println("돈을 다르게 입력했다.");
			System.out.println("재입력을 요청하자");

			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('입력한 금액이 다릅니다.');");
			out.print("history.back();");
			out.print("</script>");
		}

		// String price = Pdao.select();
		// System.out.println("price:::::" + price);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}
}
