package com.jihye.parking.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//insert, update, delete, select 작업 수행할 메소드로 구성
public class Mdao {

	static ArrayList<Mdto> list;

	public static boolean insertGuest(String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "INSERT INTO MEMBER (carNum) " + "VALUES (?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setString(1, carNum);
			// 4. DB에 DATA를 업데이트 한다.
			flag = pstmt.executeUpdate();
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
			System.out.println("게스트 등록 성공");
			return true;
		} else {
			// 실패
			return false;
		}

	}

	public static boolean insert(String name, String carNum, String type) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "INSERT INTO MEMBER (name, carNum, type, expDate) " + "VALUES (?, ?, ?, ?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setString(1, name);
			pstmt.setString(2, carNum);
			pstmt.setString(3, type);

			Date today = new Date();
			System.out.println(today); // Sat Jul 14 22:25:03 IST 2018

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 4);
			java.util.Date now = cal.getTime();

			pstmt.setTimestamp(4, new java.sql.Timestamp(now.getTime()));
			// 4. DB에 DATA를 업데이트 한다.
			flag = pstmt.executeUpdate();
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
			System.out.println("memberdao 성공");
			return true;
		} else {
			// 실패
			return false;
		}

	}

	public static String select(String carNum) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 1. DB 연결
		con = new DBConnect().getCon();
		String sql = "SELECT type FROM MEMBER WHERE carNum = ?";
		// 2.SQL문 준비
		pstmt = con.prepareStatement(sql);
		// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
		pstmt.setString(1, carNum);
		// 4. DB에 DATA를 업데이트 한다.
		rs = pstmt.executeQuery();

		System.out.println("MDAO select 성공");

		while (rs.next()) {

			// 지정한 칼럼 name 값을 가져온다.
			String type = rs.getString("type");
			System.out.println("type:::::::" + type);
			/*
			 * MDto m = new MDto(name, carNum); member.add(m);
			 */

			switch (type) {
			case "1":
				return "1";
			case "2":
				return "2";
			}

		}
		return "0";

	}

	public static boolean isGuest(String ucarNum) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 1. DB 연결
		con = new DBConnect().getCon();
		String sql = "SELECT carNum FROM MEMBER WHERE carNum = ?";
		// 2.SQL문 준비
		pstmt = con.prepareStatement(sql);
		// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
		pstmt.setString(1, ucarNum);
		// 4. DB에 DATA를 업데이트 한다.
		rs = pstmt.executeQuery();

		System.out.println("isGuest 메서드 성공");

		while (rs.next()) {

			// 지정한 칼럼 name 값을 가져온다.
			String carNum = rs.getString("carNum");
			System.out.println("ucarNum:::::::" + ucarNum);
			/*
			 * MDto m = new MDto(name, carNum); member.add(m);
			 */

			if (carNum.equals(ucarNum)) {
				// 같은 게 있다. 멤버다.
				return false;
			}
		}
		return true;
	}

	public static List<Mdto> select() throws SQLException {

		ArrayList<Mdto> member = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = new DBConnect().getCon();
		String sql = "SELECT * FROM MEMBER";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		System.out.println("MDAO select 성공");

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String carNum = rs.getString(3);
			String type = rs.getString(4);
			String regDate = rs.getString(5);
			String expDate = rs.getString(6);

			// Mdto m = new Mdto(id, name, carNum, type, regDate, expDate);
			// member.add(m);
		}

		return member;
	}

	public static int checkMemberType(String carNum) {

		return 0;
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
			String sql = "DELETE FROM member WHERE carNum = ?";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			System.out.println("sql문 준비");
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setString(1, carNum);
			System.out.println("slq문 바인딩");
			// 4. DB에 DATA를 업데이트 한다.
			flag = pstmt.executeUpdate();
			System.out.println("db에 데이터 업데이트");
			System.out.println("mdao 딜리트 진입");
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
			System.out.println("게스트 멤버 딜리트 성공");

		} else {
			// 실패

			System.out.println("게스트 멤버 딜리트  실패");
		}
	}

	public static Date getExpdate(String carNum) throws SQLException {

		System.out.println("getExpdate 진입");
		Date expDate = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 1. DB 연결
		con = new DBConnect().getCon();
		String sql = "SELECT expDate FROM MEMBER WHERE carNum = ?";
		// 2.SQL문 준비
		pstmt = con.prepareStatement(sql);
		// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
		pstmt.setString(1, carNum);
		// 4. DB에 DATA를 업데이트 한다.
		rs = pstmt.executeQuery();

		System.out.println("getExpdate 성공");

		while (rs.next()) {

			expDate = rs.getDate("expDate");
			System.out.println("mdao expDate:::::::" + expDate);

		}

		return expDate;
	}

	public static ArrayList<Mdto> selectMember() throws SQLException {

		ArrayList<Mdto> list = new ArrayList<Mdto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("selectMember 진입 ");

		con = new DBConnect().getCon();
		String sql = "SELECT * FROM MEMBER WHERE expDate is not null";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {

			int id = rs.getInt(1);
			String name = rs.getString(2);
			String carNum = rs.getString(3);
			String type = rs.getString(4);
			String regDate = rs.getString(5);
			String expDate = rs.getString(6);

			System.out.println(carNum);
			System.out.println(type);
			System.out.println("왜 안나와 날짜 나와라 날짜:" + regDate);
			System.out.println("왜 안나와 날짜 나와라 날짜:" + expDate);

			Mdto m = new Mdto(id, name, carNum, type, regDate, expDate);
			list.add(m);

			/*
			 * for (Mdto temp : list) { System.out.println("어드민id:::" + temp.getId());
			 * System.out.println("어드민name:::" + temp.getName());
			 * System.out.println("어드민carNum:::" + temp.getCarNum());
			 * System.out.println("어드민type:::" + temp.getType());
			 * System.out.println("어드민regDate:::" + temp.getRegDate());
			 * System.out.println("어드민expDate:::" + temp.getExpDate()); }
			 */
			System.out.println("selectforadmin 보관 완료");

		}

		return list;

	}

}
