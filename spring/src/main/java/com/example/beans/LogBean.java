package com.example.beans;

public class LogBean {
	private int lid;
	private String timeIn;
	private String timeOut;
	private String carNum;

	@Override
	public String toString() {
		return "LogBean [lid=" + lid + ", timeIn=" + timeIn + ", timeOut=" + timeOut + ", carNum=" + carNum + "]";
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

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

}
