package com.seek.bookstore.domain;

/**
 * Created by ${Seek} on 2017/2/14
 */
public class TradeItem {
	private Integer tradeItemId;
	private int bookId;
	private Integer tradeId;
	private Integer quantity;

	private Book book;

	public TradeItem() {
	}

	public TradeItem(Integer tradeItemId, int bookId, Integer tradeId, Integer quantity, Book book) {
		this.tradeItemId = tradeItemId;
		this.bookId = bookId;
		this.tradeId = tradeId;
		this.quantity = quantity;
		this.book = book;
	}

	@Override
	public String toString() {
		return "TradeItem{" +
				"tradeItemId=" + tradeItemId +
				", bookId=" + bookId +
				", quantity=" + quantity +
				'}';
	}

	public Integer getTradeItemId() {
		return tradeItemId;
	}

	public void setTradeItemId(Integer tradeItemId) {
		this.tradeItemId = tradeItemId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
