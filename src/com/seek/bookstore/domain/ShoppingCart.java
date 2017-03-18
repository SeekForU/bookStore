package com.seek.bookstore.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${Seek} on 2017/2/26
 */
public class ShoppingCart {

	Map<Integer, ShoppingCartItem> books = new HashMap<>();

	/**
	 * 修改指定购物项的数量
	 */
	public void updateItemQuantity(Integer id, int quantity) {
		ShoppingCartItem shoppingCartItem = books.get(id);
		if (shoppingCartItem != null) {
			shoppingCartItem.setQuantity(quantity);
		}
	}

	/**
	 * 移除制定的购物项
	 * @param id
	 */
	public void removeItem(Integer id) {
		books.remove(id);
	}

	/**
	 * 清空购物车
	 */
	public void clear() {
		books.clear();
	}

	public boolean isEmpty() {
		return books.isEmpty();
	}

	public float getTotalMoney() {
		float total = 0;

		for (ShoppingCartItem shoppingCartItem : getItems()) {
			total += shoppingCartItem.getItemMoney();
		}

		return total;
	}

	/**
	 * 获取购物车中的所有的 ShoppingCartItem 组成的集合
	 * @return
	 */
	public Collection<ShoppingCartItem> getItems() {
		return books.values();
	}

	/**
	 * 返回购物车中商品的总数量
	 * @return
	 */
	public int getBookNumber() {
		int total = 0;

		for(ShoppingCartItem sci : books.values()) {
			total += sci.getQuantity();
		}

		return total;
	}

	public Map<Integer, ShoppingCartItem> getBooks() {
		return books;
	}


	public boolean hasBook(Integer id) {
		return books.containsKey(id);
	}

	/**
	 * 向购物车中添加一件商品
	 * @param book
	 */
	public void addBook(Book book) {
		/**
		 * 检查购物车中有没有该商品，若有，则使其数量加1，若没有
		 * 则创建新的shoppingCartItem，并加入到books
		 */
		ShoppingCartItem shoppingCartItem = books.get(book.getId());

		if (shoppingCartItem == null) {
			shoppingCartItem = new ShoppingCartItem(book);
			books.put(book.getId(), shoppingCartItem);
		} else {
			shoppingCartItem.increment();
		}
	}
}
