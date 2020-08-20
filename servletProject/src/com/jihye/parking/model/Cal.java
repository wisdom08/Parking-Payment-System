package com.jihye.parking.model;

public class Cal {

	private int price;
	private String timeIn;
	private String timeOut;

	public Cal() {
		// TODO Auto-generated constructor stub
	}

	public Cal(int price, String timeIn, String timeOut) {

		System.out.println(timeIn);
		System.out.println(timeOut);

		this.price = price;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
