package com.jihye.parking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jihye.parking.model.Ldao;
import com.jihye.parking.model.Ldto;
import com.jihye.parking.model.Mdao;
import com.jihye.parking.model.Pdao;
import com.jihye.parking.model.Time;

@WebServlet("/inquire")
public class Inquire extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");

		String carNum = req.getParameter("carNum");
		System.out.println("jssp에서 넘어온 " + req.getParameter("carNum"));

		boolean parkCheck = Ldao.selectLogCheck(carNum);

		System.out.println("입차여부 체크!!! " + parkCheck);

		if (!parkCheck) {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.print("<script type='text/javascript'>");
			out.print("alert('입차한 차량이 아닙니다. ');");
			out.print("location.href='/';");
			out.print("</script>");

			return;
		}

		String mType = "0";
		try {
			mType = Mdao.select(carNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("memberType::::" + mType);

		boolean timeoutUpdate = false;
		try {
			timeoutUpdate = Ldao.update(carNum);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.println("timeoutUpdate::::" + timeoutUpdate);

		ArrayList<Ldto> logs = Ldao.selectLog(carNum);

		for (Ldto temp : logs) {
			System.out.println("log조회 " + temp.getCarNum());
			System.out.println("log조회 " + temp.getTimeIn());
			System.out.println("log조회 " + temp.getTimeOut());
		}

		try {

			ArrayList<Ldto> timebox = Ldao.select(carNum);

			String in = null;
			String out = null;
			for (Ldto temp : timebox) {
				System.out.println("timein:::" + temp.getTimeIn());
				System.out.println("timeout:::" + temp.getTimeOut());

				in = temp.getTimeIn();
				out = temp.getTimeOut();
			}

			List<Time> times = calTime(in, out);

			long d = 0;
			long h = 0;
			long m = 0;
			long s = 0;

			for (Time temp : times) {
				d = temp.getDays();
				h = temp.getHours();
				m = temp.getMinutes();
				s = temp.getSeconds();
			}

			long price = calPrice(d, h);

			switch (mType) {
			case "0":
				req.setAttribute("mType", "0");
				System.out.println("멤버타입:::::" + mType);
				break;
			case "1":
				req.setAttribute("mType", "1");
				System.out.println("멤버타입:::::" + mType);
				break;
			case "2":
				req.setAttribute("mType", "2");
				System.out.println("멤버타입:::::" + mType);
				break;
			case "4":
				req.setAttribute("mType", "4");
				System.out.println("멤버타입:::::" + mType);
				break;
			}

			if (mType.equals("1")) {
				price = 0;
			} else if (mType.equals("2")) {
				price = price / 2;
			}

			// 계산 과정 거친 시간이랑 가격 jsp로 보내서 뿌리자.
			req.setAttribute("times", times);
			req.setAttribute("price", price);
			req.setAttribute("logs", logs);

			boolean pdaoresult = Pdao.insert(price, carNum);
			System.out.println("pdaoinserturesutl:::" + pdaoresult);

			if (price == 0) {
				Pdao.delete(carNum);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dp = req.getRequestDispatcher("/inquire.jsp");
		dp.forward(req, res);

	}

	private long calPrice(long d, long h) {

		if (d != 0) {
			d *= 12000;
		}

		if (h == 0) {
			h = 1;
		}

		if (h != 0) {
			h *= 1000;
		}

		return d + h;

	}

	private List<Time> calTime(String in, String out) {

		String tstart = in;
		String tstop = out;

		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(tstart);
			d2 = format.parse(tstop);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Get msec from each, and subtract.
		long diff = d2.getTime() - d1.getTime();

		long days = TimeUnit.MILLISECONDS.toDays(diff);
		long remainingHoursInMillis = diff - TimeUnit.DAYS.toMillis(days);
		long hours = TimeUnit.MILLISECONDS.toHours(remainingHoursInMillis);
		long remainingMinutesInMillis = remainingHoursInMillis - TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(remainingMinutesInMillis);
		long remainingSecondsInMillis = remainingMinutesInMillis - TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(remainingSecondsInMillis);

		System.out.println("Days: " + days + ", hours: " + hours + ", minutes: " + minutes + ", seconds: " + seconds);

		List<Time> tlist = new ArrayList<Time>();
		tlist.add(new Time(days, hours, minutes, seconds));

		for (Time temp : tlist) {
			System.out.println("시간 객체 테스트::::" + temp.getDays());
			System.out.println("시간 객체 테스트::::" + temp.getHours());
			System.out.println("시간 객체 테스트::::" + temp.getMinutes());
			System.out.println("시간 객체 테스트::::" + temp.getSeconds());
		}

		return tlist;

	}

}
