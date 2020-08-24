package com.jihye.parking.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

//insert, update, delete, select 작업 수행할 메소드로 구성
public class Ldao {

	static ArrayList<Ldto> list;

	public static ArrayList<Ldto> selectforadmin() throws SQLException {

		list = new ArrayList<>();
		Connection con = null;
		con = new DBConnect().getCon();
		Statement stmt = con.createStatement();
		System.out.println("selectforadmin 진입 ");

		String sql = "SELECT * FROM logs";

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			int lid = rs.getInt(1);
			String timeIn = rs.getString(2);
			String timeOut = rs.getString(3);
			String carNum = rs.getString(4);

			Ldto l = new Ldto(lid, timeIn, timeOut, carNum);
			list.add(l);

			for (Ldto temp : list) {
				System.out.println("어드민lid:::" + temp.getLid());
				System.out.println("어드민timeIn:::" + temp.getTimeIn());
				System.out.println("어드민timeOut:::" + temp.getTimeOut());
				System.out.println("어드민carNum:::" + temp.getCarNum());
			}
			System.out.println("selectforadmin 보관 완료");

		}

		return list;

	}

	public static boolean insert(String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(carNum);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			System.out.println("db연결완료");
			String sql = "INSERT INTO logs (carNum) " + "VALUES (?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			System.out.println("sql문 준비");
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setString(1, carNum);
			System.out.println("slq문 바인딩");
			// 4. DB에 DATA를 업데이트 한다.
			flag = pstmt.executeUpdate();
			System.out.println("db에 데이터 업데이트");
			System.out.println("Ldao 진입");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 사용한 객체를 닫아준다.
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (flag > 0) {
			// 성공
			System.out.println("Ldao 성공");
			return true;
		} else {
			// 실패

			System.out.println("Ldao 실패");
			return false;
		}

	}

	public static boolean update(String carNum) throws SQLException {

		System.out.println("ldao timeout update 진입");

		Connection con = null;
		PreparedStatement pstmt = null;

		int flag = 0;

		/*
		 * String memberType = Mdao.select(ucarNum);
		 * 
		 * if(memberType.equals("4")) { System.out.println("입차 x"); } else
		 * if(memberType.equals("1"))
		 * 
		 */

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			System.out.println("db연결완료");
			String sql = "UPDATE logs SET timeOut = ? WHERE carNum = ?";

			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			System.out.println("sql문 준비");
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기

			Calendar calendar = Calendar.getInstance();
			java.util.Date now = calendar.getTime();

			pstmt.setTimestamp(1, new java.sql.Timestamp(now.getTime()));
			pstmt.setString(2, carNum);
			System.out.println("slq문 바인딩");
			// 4. DB에 DATA를 업데이트 한다.
			flag = pstmt.executeUpdate();
			System.out.println("db에 데이터 업데이트");
			System.out.println("Ldao update 진입");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 사용한 객체를 닫아준다.
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (flag > 0) {
			// 성공
			System.out.println("Ldao update 성공");
			return true;
		} else {
			// 실패

			System.out.println("Ldao update 실패");
			return false;
		}

	}

	public static ArrayList<Ldto> select(String ucarNum) throws SQLException {

		ArrayList<Ldto> list = new ArrayList<Ldto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("ldto select 진입 ");

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "SELECT timeIn, timeOut FROM logs WHERE carNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ucarNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String timeIn = rs.getString("timeIn");
				String timeOut = rs.getString("timeOut");

				Ldto l = new Ldto(timeIn, timeOut);
				list.add(l);

				System.out.println("time 보관 완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 사용한 객체를 닫아준다.
				if (con != null)
					con.close();
				// if (stmt != null)
				// stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;
	}

	public static ArrayList<Ldto> selectLog(String carNum) {

		ArrayList<Ldto> list = new ArrayList<Ldto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("ldao selectLog 진입 ");

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "SELECT * FROM logs WHERE carNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				String timeIn = rs.getString("timeIn");
				String timeOut = rs.getString("timeOut");
				String ucarNum = rs.getString("carNum");

				System.out.println(timeIn);
				System.out.println(timeOut);
				System.out.println(ucarNum);

				Ldto l = new Ldto(timeIn, timeOut, ucarNum);
				list.add(l);

				System.out.println("inquiry log 보관 완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 사용한 객체를 닫아준다.
				if (con != null)
					con.close();
				// if (stmt != null)
				// stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return list;

	}

	public static boolean selectLogCheck(String ucarNum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("입차한 차량 체크 메서드 진입 ");

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "SELECT carNum FROM logs WHERE carNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ucarNum);
			rs = pstmt.executeQuery();

			String carNum = null;

			while (rs.next()) {
				carNum = rs.getString("carNum");
				System.out.println("carNum!!!!!!!" + carNum);
			}

			if (carNum == null) {
				// 기록된 carNum이 없다.
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 사용한 객체를 닫아준다.
				if (con != null)
					con.close();
				// if (stmt != null)
				// stmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return true;

	}

	public static void delete(String carNum) {
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(carNum);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			System.out.println("db연결완료");
			String sql = "DELETE FROM logs WHERE carNum = ?";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			System.out.println("sql문 준비");
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setString(1, carNum);
			System.out.println("slq문 바인딩");
			// 4. DB에 DATA를 업데이트 한다.
			flag = pstmt.executeUpdate();
			System.out.println("db에 데이터 업데이트");
			System.out.println("Ldao 딜리트 진입");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 사용한 객체를 닫아준다.
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (flag > 0) {
			// 성공
			System.out.println("로그 딜리트 성공");

		} else {
			// 실패

			System.out.println("로그 딜리트  실패");
		}
	}

	public static void select() {

	}

}
