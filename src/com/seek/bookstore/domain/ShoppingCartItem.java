package com.seek.bookstore.domain;

/**
 * Created by ${Seek} on 2017/2/26
 */
public class ShoppingCartItem {
	private Book book;

	private int quantity;

	public ShoppingCartItem(Book book) {
		this.book = book;
		this.quantity = 1;
	}

	public Book getBook() {
		return book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 返回购物车中的商品钱数
	 * @return
	 */
	public float getItemMoney() {
		return book.getPrice() * quantity;
	}

	/**
	 * 购物车中的商品数量加1
	 */
	public void increment() {
		quantity++;
	}
}
