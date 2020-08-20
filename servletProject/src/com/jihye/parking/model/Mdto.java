package com.jihye.parking.model;

public class Mdto {

	int mid;
	String name;
	String carNum;
	int type;
	String regDate;
	String expDate;

	public Mdto() {
	}

	public Mdto(int mid, String name, String carNum, int type, String regDate, String expDate) {
		super();
		this.mid = mid;
		this.name = name;
		this.carNum = carNum;
		this.type = type;
		this.regDate = regDate;
		this.expDate = expDate;
	}

	public int getId() {
		return mid;
	}

	public void setId(int mid) {
		this.mid = mid;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", carNum=" + carNum + ", type=" + type + ", regDate="
				+ regDate + ", expDate=" + expDate + "]";
	}

}
