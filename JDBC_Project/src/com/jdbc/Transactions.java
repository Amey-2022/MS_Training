package com.jdbc;

import java.sql.Date;

public class Transactions {
	private int transaction_id;
	private Date transaction_date;
	private double transaction_amount;
	private int account_number;
	private String transaction_details;
	
	
	public Transactions(Date transaction_date, double transaction_amount, int account_number,
			String transaction_details) {
		//super();
		//this.transaction_id = transaction_id;
		this.transaction_date = transaction_date;
		this.transaction_amount = transaction_amount;
		this.account_number = account_number;
		this.transaction_details = transaction_details;
	}


	public int getTransaction_id() {
		return transaction_id;
	}


//	public void setTransaction_id(int transaction_id) {
//		this.transaction_id = transaction_id;
//	}


	public Date getTransaction_date() {
		return transaction_date;
	}


	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}


	public double getTransaction_amount() {
		return transaction_amount;
	}


	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}


	public int getAccount_number() {
		return account_number;
	}


	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}


	public String getTransaction_details() {
		return transaction_details;
	}


	public void setTransaction_details(String transaction_details) {
		this.transaction_details = transaction_details;
	}


	@Override
	public String toString() {
		return "Transactions [transaction_id=" + transaction_id + ", transaction_date=" + transaction_date
				+ ", transaction_amount=" + transaction_amount + ", account_number=" + account_number
				+ ", transaction_details=" + transaction_details + "]";
	}
	
	
	
	
	
}



