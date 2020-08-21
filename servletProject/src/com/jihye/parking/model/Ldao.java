package com.jihye.parking.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

//insert, update, delete, select 작업 수행할 메소드로 구성
public class Ldao {

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

	public static boolean update(String ucarNum) {

		System.out.println("ldao timeout update 진입");

		Connection con = null;
		PreparedStatement pstmt = null;

		int flag = 0;

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
			pstmt.setString(2, ucarNum);
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

}
