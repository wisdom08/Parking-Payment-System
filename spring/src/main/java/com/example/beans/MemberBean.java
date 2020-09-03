package com.example.beans;

public class MemberBean {
	private int mid;
	private String name;
	private String carNum;
	private String type;
	private String regDate;
	private String expDate;

	@Override
	public String toString() {
		return "MemberBean [id=" + mid + ", name=" + name + ", carNum=" + carNum + ", type=" + type + ", regDate="
				+ regDate + ", expDate=" + expDate + "]";
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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

}
