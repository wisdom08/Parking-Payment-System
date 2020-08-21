package com.jihye.parking.model;

public class Ldto {

	int lid;
	String timeIn;
	String timeOut;
	String carNum;

	public Ldto() {
	}

	public Ldto(String carNum) {
		super();
		this.carNum = carNum;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Ldto(int lid, String timeIn, String timeOut, String carNum) {
		super();
		this.lid = lid;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.carNum = carNum;
	}

	public Ldto(String timeIn, String timeOut, String carNum) {
		super();
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.carNum = carNum;
	}

	public Ldto(String timeIn2, String timeOut2) {
		timeIn = timeIn2;
		timeOut = timeOut2;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(String timeIn) {
		this.timeIn = timeIn;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

}
