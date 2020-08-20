package com.jihye.parking.controller;

import java.io.IOException;
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

@WebServlet("/check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		String carNum = req.getParameter("carNum");

		System.out.println("check controller");

		System.out.println("carNum::::::" + carNum);
		req.setAttribute("carNum", carNum);

		int mType = 0;
		try {
			mType = Mdao.select(carNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("memberType::::" + mType);

		// member 타입에 따라 분기문
		// 0, 1,2 => 계산 // 4 => 입차하지 않은 차량이라고 안내
		// 0=> 금액 그대로 계산
		// 1=> 0원, 기간 안내, 기간연장 여부 확인, 연장시 결제
		// 2=> 50% 할인, 금액 안내 , 결제

		boolean timeoutUpdate = Ldao.update(carNum);
		System.out.println("timeoutUpdate::::" + timeoutUpdate);

		switch (mType) {
		case 0:
			req.setAttribute("mType", 0);
			break;
		case 1:
			req.setAttribute("mType", 1);
			break;
		case 2:
			req.setAttribute("mType", 2);
			break;
		case 4:
			req.setAttribute("mType", 4);
			break;
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

			// 계산 과정 거친 시간이랑 가격 jsp로 보내서 뿌리자.
			req.setAttribute("times", times);
			req.setAttribute("price", price);

			boolean pdaoresult = Pdao.insert(price, carNum);
			System.out.println("pdaoinserturesutl:::" + pdaoresult);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher dp = req.getRequestDispatcher("/payment.jsp");
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
