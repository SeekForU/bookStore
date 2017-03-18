package com.seek.bookstore.dao;

import com.seek.bookstore.domain.Trade;

import java.util.Set;

/**
 * Created by ${Seek} on 2017/2/15
 */
public interface TradeDAO {

	/**
	 * 插入Trade对象
	 * @param trade
	 */
	void insert(Trade trade);


	//根据 userId 获取和其关联的 Trade 的集合

	Set<Trade> getTradesByUserId(Integer userId);
}
