package com.seek.bookstore.domain;

/**
 * Created by ${Seek} on 2017/2/14
 */
public class Account {

	private Integer accountId;

	private int balance;

	public Account() {
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account{" +
				"accountId=" + accountId +
				", balance=" + balance +
				'}';
	}
}
