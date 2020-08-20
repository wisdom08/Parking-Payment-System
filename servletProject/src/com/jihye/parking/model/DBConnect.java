package com.jihye.parking.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	// 필드
	private Connection con;

	// 생성자
	public DBConnect() {
		try {

			// 연결하려는 드라이버명
			String driver = "com.mysql.cj.jdbc.Driver";
			// 드라이버 로딩
			Class.forName(driver);
			// 접속할 디비 정보
			String url = "jdbc:mysql://localhost:3333/parking_system?&useSSL=false&serverTimezone=UTC";
			String user = "j";
			String password = "1234";
			// 접속하고 Connection 객체의 참조값 얻어오기(db 연동의 핵심 객체)
			con = DriverManager.getConnection(url, user, password);
			System.out.println("디비 접속 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 메소드
	public Connection getCon() {
		return con;
	}

}
