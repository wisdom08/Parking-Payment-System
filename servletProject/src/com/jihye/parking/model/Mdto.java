package com.jihye.parking.model;

public class Mdto {

	int id;
	String name;
	String carNum;
	String type;
	String regDate;
	String expDate;

	public Mdto() {
	}

	public Mdto(int id, String name, String carNum, String type, String regDate, String expDate) {
		this.id = id;
		this.name = name;
		this.carNum = carNum;
		this.type = type;
		this.regDate = regDate;
		this.expDate = expDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", carNum=" + carNum + ", type=" + type + ", regDate=" + regDate
				+ ", expDate=" + expDate + "]";
	}

}
