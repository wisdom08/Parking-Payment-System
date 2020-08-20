package com.jihye.parking.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDBUtil {

	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3333/parking_system?&useSSL=false&serverTimezone=UTC";
	static String user = "j";
	static String password = "1234";

	static ArrayList<Mdto> member;

	public static List<Mdto> getMemberList() throws ClassNotFoundException, SQLException {

		member = new ArrayList<>();

		// load the mysql driver
		Class.forName(driver);

		// get the connection
		Connection con = DriverManager.getConnection(url, user, password);

		// create a statement
		Statement stmt = con.createStatement();

		String sqlS = "SELECT * FROM MEMBER";

		// 특정열만 검색:: "SELECT name, carNum, type, regDate, expDate FROM MEMBER";
		// 조건 검색:: "SELECT * FROM MEMBER where ~ ";

		// execute the statement and loop over the result set
		ResultSet rs = stmt.executeQuery(sqlS);

		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String carNum = rs.getString(3);
			int type = rs.getInt(4);
			Date regDate = rs.getDate(5);
			Date expDate = rs.getDate(6);

			/*
			 * Mdto m = new Mdto(id, name, carNum, type, regDate, expDate); member.add(m);
			 */
		}

		return member;
	}

	public static void insert(String name, String carNum, String type) throws ClassNotFoundException, SQLException {

		System.out.println("insert 실행 ");

		member = new ArrayList<>();

		// JDBC 드라이버 로딩
		Class.forName(driver);

		// Connection 객체 생성
		Connection con = DriverManager.getConnection(url, user, password);

		// PreparedStatement 객체 생성, 객체 생성 시 sql 문장 저장
		PreparedStatement pstmt;
		String sqlI = "INSERT INTO MEMBER (name, carNum, type) " + "VALUES (?, ?, ?)";
		pstmt = con.prepareStatement(sqlI);

		// pstmt.set<데이터타입>(순서,값)
		pstmt.setString(2, name);
		pstmt.setString(3, carNum);
		pstmt.setString(4, type);

		// sql 문장 실행하고 결과 리턴
		int row = pstmt.executeUpdate();
		System.out.println("변경 된 row :::: " + row);

		pstmt.close();
		con.close();
	}
}