package com.seek.bookstore.domain;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ${Seek} on 2017/2/14
 */
public class User {

	private Integer userId;

	private String username;

	private int accountId;

	private Set<Trade> trades = new LinkedHashSet<Trade>();

	public User() {
	}

	public User(Integer userId, String username, int accountId, Set<Trade> trades) {
		this.userId = userId;
		this.username = username;
		this.accountId = accountId;
		this.trades = trades;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Set<Trade> getTrades() {
		return trades;
	}

	public void setTrades(Set<Trade> trades) {
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", accountId=" + accountId +
				", trades=" + trades +
				'}';
	}
}
