package com.seek.bookstore.impl;

import com.seek.bookstore.dao.BookDAO;
import com.seek.bookstore.domain.Book;
import com.seek.bookstore.web.CriteriaBook;
import com.seek.bookstore.web.Page;

import java.util.List;

/**
 * Created by ${Seek} on 2017/2/15
 */
public class BookDAOImpl extends BaseDao<Book> implements BookDAO {

	@Override
	public Book getBook(int id) {
		String sql = "SELECT id,author,title,price,publishingDate," +
				"salesAmount,storeNumber,remark FROM mybooks WHERE id = ?";
		return query(sql, id);
	}

	//3
	@Override
	public Page<Book> getPage(CriteriaBook criteriaBook) {
		Page<Book> page = new Page<>(criteriaBook.getPageNo());

		page.setTotalItemNumber(getTotalBookNumber(criteriaBook));
		//校验 pageNo 的合法性
		criteriaBook.setPageNo(page.getPageNo());
		page.setList(getPageList(criteriaBook, 3));
		return page;
	}

	//1.

	/**
	 * 1.获取书的数量
	 * @param criteriaBook
	 * @return
	 */
	@Override
	public long getTotalBookNumber(CriteriaBook criteriaBook) {
		String sql = "SELECT count(id) FROM mybooks WHERE price < ? AND price > ?";
		return getSingleVal(sql, criteriaBook.getMaxPrice(), criteriaBook.getMinPrice());
	}

	/**2.获取页的list
	 *  MySQL 分页使用 LIMIT, 其中 fromIndex 从 0 开始
	 * @param criteriaBook
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Book> getPageList(CriteriaBook criteriaBook, int pageSize) {

		//String sql = "SELECT id,author,title,price,publishingDate," +
		//
		//		"salesAmount,storeNumber,remark FROM mybooks " +
		//		"WHERE price > ? AND price < ?" +
		//		"LIMIT ?,?";

		String sql = "SELECT id, author, title, price, publishingDate, " +
				"salesAmount, storeNumber, remark FROM mybooks " +
				"WHERE price >= ? AND price <= ? " +
				"LIMIT ?, ?";
		return queryForList(sql,criteriaBook.getMinPrice(),criteriaBook.getMaxPrice(),
		(criteriaBook.getPageNo() - 1) * pageSize, pageSize);
	}

	/**
	 * 获取storeNumber
	 * @param id
	 * @return
	 */
	@Override
	public int getStoreNumber(Integer id) {
		String sql = "SELECT storeNumber FROM mybooks WHERE id = ?";
		return getSingleVal(sql, id);
	}
}
