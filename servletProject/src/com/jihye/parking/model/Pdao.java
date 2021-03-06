package com.jihye.parking.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pdao {

	static ArrayList<Pdto> list;

	public static boolean insert(int amount, String method, String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(amount);
		System.out.println(method);
		System.out.println(carNum);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "INSERT INTO payment (amount, method, carNum) " + "VALUES (?, ?, ?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setInt(1, amount);
			pstmt.setString(2, method);
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

	public static boolean insert(String name, int amount, String method, String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(amount);
		System.out.println(method);
		System.out.println(carNum);
		System.out.println(name);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "INSERT INTO payment (name, amount, method, carNum) " + "VALUES (?, ?, ?, ?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setString(1, name);
			pstmt.setInt(2, amount);
			pstmt.setString(2, method);
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

	public static boolean update(String method, String carNum) {

		System.out.println("pdao method update 진입");

		Connection con = null;
		PreparedStatement pstmt = null;

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			System.out.println("db연결완료");
			String sql = "UPDATE payment SET method = ? WHERE carNum = ?";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			System.out.println("sql문 준비");
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기

			pstmt.setString(1, method);
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

	public static boolean insert(long price, String carNum) throws SQLException {

		String checkMemberType = Mdao.select(carNum);
		System.out.println("checkMemberType" + checkMemberType);

		if (checkMemberType.equals("1")) {
			price = 0;
		} else if (checkMemberType.equals("2")) {
			price = price / 2;
		}

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println("회원은 가격0, 쿠폰은 50%나와야한다::::" + price);
		System.out.println("carNum" + carNum);

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

	public static boolean updateAmount(String carNum, String type) {

		System.out.println("pdao 타입별 가격 update 진입");

		Connection con = null;
		PreparedStatement pstmt = null;

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			System.out.println("db연결완료");
			String sql = "UPDATE payment SET amount = ? WHERE carNum = ?";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			System.out.println("sql문 준비");
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기

			if (type.equals("2")) {
				int amount = 0;
				amount = amount / 2;
				pstmt.setInt(1, amount);

			} else if (type.equals("1")) {
				int amount = 0;
				pstmt.setInt(1, amount);
			}

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

	public static ArrayList<Pdto> select(String carNum) {

		ArrayList<Pdto> list = new ArrayList<Pdto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("Pdao select 진입 ");

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "SELECT * FROM payment WHERE carNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				int amount = rs.getInt("amount");
				String method = rs.getString("method");

				System.out.println(amount);
				System.out.println(method);

				Pdto p = new Pdto(amount, method);
				list.add(p);

				System.out.println("pdao select 보관 완료");
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

	public static ArrayList<Pdto> selectforadmin() throws SQLException {

		list = new ArrayList<>();
		Connection con = null;
		con = new DBConnect().getCon();
		Statement stmt = con.createStatement();
		System.out.println("selectforadmin 진입 ");

		String sql = "SELECT * FROM payment";

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			int pid = rs.getInt(1);
			int amount = rs.getInt(2);
			String method = rs.getString(3);
			String date = rs.getString(4);
			String carNum = rs.getString(5);

			Pdto p = new Pdto(pid, amount, method, date, carNum);
			list.add(p);

			for (Pdto temp : list) {
				System.out.println("어드민amount:::" + temp.getAmount());
				System.out.println("어드민pid:::" + temp.getPid());
				System.out.println("어드민carNum:::" + temp.getCarNum());
				System.out.println("어드민method:::" + temp.getMethod());
				System.out.println("어드민date:::" + temp.getDate());
			}
			System.out.println("selectforadmin 보관 완료");

		}

		return list;

	}

	public static int getAmount(String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("Pdao getAmount 진입 ");
		int amount = 0;
		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "SELECT amount FROM payment WHERE carNum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, carNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				amount = rs.getInt("amount");
				System.out.println("amount" + amount);
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

		return amount;

	}

	public static boolean insertp(String price, String method, String carNum) {
		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(price);
		System.out.println(method);
		System.out.println(carNum);
		int num = Integer.parseInt(price);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			String sql = "INSERT INTO payment (amount, method, carNum) " + "VALUES (?, ?, ?)";
			// 2.SQL문 준비
			pstmt = con.prepareStatement(sql);
			// 3. 준비된 SQL문의 물음표마다 값 바인딩하기
			pstmt.setInt(1, num);
			pstmt.setString(2, method);
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

	public static void delete(String carNum) {

		Connection con = null;
		PreparedStatement pstmt = null;

		System.out.println(carNum);

		int flag = 0;

		try {
			// 1. DB 연결
			con = new DBConnect().getCon();
			System.out.println("db연결완료");
			String sql = "DELETE FROM payment WHERE carNum = ?";
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
			System.out.println("0원 로그 딜리트 성공");

		} else {
			// 실패

			System.out.println("0원 로그 딜리트  실패");
		}
	}

}
