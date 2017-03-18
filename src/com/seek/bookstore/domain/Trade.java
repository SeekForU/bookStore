package com.seek.bookstore.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by ${Seek} on 2017/2/14
 */
public class Trade {

	//交易对象的id
	private Integer tradeId;

	//和Trade
	private int userId;
	//交易时间
	private Date TradeTime;

	//Trade 关联的多个 TradeItem
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();

	@Override
	public String toString() {
		return "Trade{" +
				"tradeId=" + tradeId +
				", userId=" + userId +
				", TradeTime=" + TradeTime +
				", items=" + items +
				'}';
	}

	public Integer getTradeid() {
		return tradeId;
	}

	public void setTradeid(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getTradeTime() {
		return TradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		TradeTime = tradeTime;
	}

	public Set<TradeItem> getItems() {
		return items;
	}

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}
}
