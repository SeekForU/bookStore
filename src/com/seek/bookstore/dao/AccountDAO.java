package com.seek.bookstore.dao;

import com.seek.bookstore.domain.Account;

/**
 * Created by ${Seek} on 2017/2/15
 */
public interface AccountDAO {

	/**
	 * 根据id获取Account对象
	 * @param accountId
	 * @return
	 */
	Account getAccount(String accountId);


	/**
	 * 根据传入的accountId,更新对象的账户余额
	 * @param accountId
	 * @param amount
	 */
	void updateBalance(Integer accountId, float amount);
}
