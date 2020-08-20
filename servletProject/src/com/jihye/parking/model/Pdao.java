package com.jihye.parking.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Pdao {

	public static boolean insert(int amount, int type, String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(amount);
		System.out.println(type);
		System.out.println(carNum);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "INSERT INTO payment (amount, type, carNum) " + "VALUES (?, ?, ?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setInt(1, amount);
			pstmt.setInt(2, type);
			pstmt.setString(3, carNum);
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
			System.out.println("Pdao 성공");
			return true;
		} else {
			// 실패

			System.out.println("Pdao 실패");
			return false;
		}

	}

	public static boolean update() {
		return false;
	}

	public static boolean insert(long price, String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(price);
		System.out.println(carNum);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "INSERT INTO payment (amount, carNum) " + "VALUES (?, ?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setLong(1, price);
			pstmt.setString(2, carNum);
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
			System.out.println("Pdao insert 성공");
			return true;
		} else {
			// 실패

			System.out.println("Pdao insert 실패");
			return false;
		}

	}

	public static boolean update(String type, String carNum) {

		System.out.println("pdao method update 진입");

		Connection con = null;
		PreparedStatement pstmt = null;

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			System.out.println("db연결완료");
			String sql = "UPDATE payment SET type = ? WHERE carNum = ?";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			System.out.println("sql문 준비");
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기

			pstmt.setString(1, type);
			pstmt.setString(2, carNum);
			System.out.println("slq문 바인딩");
			// 4. DB에 DATA를 업데이트 한다.
			flag = pstmt.executeUpdate();
			System.out.println("db에 데이터 업데이트");
			System.out.println("Pdao update 진입");
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
			System.out.println("Pdao update 성공");
			return true;
		} else {
			// 실패

			System.out.println("Pdao update 실패");
			return false;
		}

	}

}