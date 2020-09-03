package com.example.beans;

public class PaymentBean {

	private int pid;
	private int amount;
	private String method;
	private String date;
	private String carNum;

	@Override
	public String toString() {
		return "PaymentBean [pid=" + pid + ", amount=" + amount + ", method=" + method + ", date=" + date + ", carNum="
				+ carNum + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

}
