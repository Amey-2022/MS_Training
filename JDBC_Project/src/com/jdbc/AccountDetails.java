package com.jdbc;

import com.constants.AccountTypes;

public class AccountDetails {
	private int user_id;
	private String accountType;
	// private long accountNumber;
	// private static int temp=0;
	private double balance;

	public AccountDetails(String accountType) {
		// super();
		this.accountType = accountType;
		this.balance = 1500;
	}

	public int getUser_id() {
		return user_id;
	}

//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountType=" + accountType + " balance=" + balance + "]";
	}

}
