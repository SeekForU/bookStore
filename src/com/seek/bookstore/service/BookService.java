package com.seek.bookstore.service;

import com.seek.bookstore.dao.BookDAO;
import com.seek.bookstore.domain.Book;
import com.seek.bookstore.domain.ShoppingCart;
import com.seek.bookstore.impl.BookDAOImpl;
import com.seek.bookstore.web.CriteriaBook;
import com.seek.bookstore.web.Page;

/**
 * Created by ${Seek} on 2017/2/23
 */
public class BookService {

	private BookDAO bookDAO = new BookDAOImpl();

	public Page<Book> getPage(CriteriaBook criteriaBook) {
		return bookDAO.getPage(criteriaBook);
	}

	public Book getBook(int id) {
		return bookDAO.getBook(id);
	}

	public boolean addToCart(int id, ShoppingCart shoppingCart) {
		Book book = bookDAO.getBook(id);
		if (book != null) {
			shoppingCart.addBook(book);
			return true;
		}
		return false;
	}

	public void removeItemFromShoppingCart(ShoppingCart shoppingCart, int id) {
		shoppingCart.removeItem(id);
	}

	public void clearShopping(ShoppingCart shoppingCart) {
		shoppingCart.clear();
	}

	public void updateItemQuantity(ShoppingCart shoppingCart, int id, int quantity) {
		shoppingCart.updateItemQuantity(id, quantity);
	}
}
