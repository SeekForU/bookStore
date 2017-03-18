package com.seek.bookstore.dao;

import com.seek.bookstore.domain.TradeItem;

import java.util.Collection;
import java.util.Set;

/**
 * Created by ${Seek} on 2017/2/15
 */
public interface TradeItemDAO {


	/**
	 * 批量保存TradeItem对象
	 * @param items
	 */
	void batchSave(Collection<TradeItem> items);


	/**
	 * 根据id获取与其相关的TradeItem集合
	 * @param tradeId
	 * @return
	 */
	Set<TradeItem> getTradeItemByTradeId(Integer tradeId);
}
