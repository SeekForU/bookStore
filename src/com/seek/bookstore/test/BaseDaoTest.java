package com.seek.bookstore.test;

import com.seek.bookstore.domain.Book;
import com.seek.bookstore.impl.BookDAOImpl;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

/**
 * Created by ${Seek} on 2017/2/15
 */
public class BaseDaoTest {

	//BaseDao baseDao = new BaseDao();

	BookDAOImpl bookDAO = new BookDAOImpl();

	@Test
	public void insertTest() {
		String sql = "INSERT INTO trade(userid,tradetime) VALUES(?,?)";
		long id = bookDAO.insert(sql,1, new Date(new java.util.Date().getTime()));
		System.out.println(id);
	}

	@Test
	public void updateTest() {
		//String sql = "UPDATE mybooks SET Salesamount = ? WHERE id = ?";
		String sql = "UPDATE mybooks SET salesamount = ? WHERE id = ?";
		bookDAO.update(sql, 10, 1);
	}

	@Test
	public void queryTest() {
		String sql = "SELECT id, author,title,price,publishingdate," +
				"salesamount,storenumber,remark FROM mybooks WHERE id = ?";
		Book book = bookDAO.query(sql, 1);
		System.out.println(book);
	}

	@Test
	public void queryForListTest() {
		//String sql = "SELECT id,author,title,price,publishingDate" +
		//		"salesAmount,storeNumber,remark FROM mybooks WHERE" +
		//		"id > ?";
		String sql = "SELECT id, author, title, price, publishingDate, " +
				"salesAmount, storeNumber, remark FROM mybooks WHERE id < ?";
		List<Book> bookList = bookDAO.queryForList(sql, 5);
		System.out.println(bookList);
	}

	@Test
	public void getSingleValTest() {
		String sql = "SELECT count(id) FROM mybooks";

		long count = bookDAO.getSingleVal(sql);
		System.out.println(count);
	}

	@Test
	public void testBatch() {

	}

}
