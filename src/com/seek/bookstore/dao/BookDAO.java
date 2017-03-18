package com.seek.bookstore.dao;

import com.seek.bookstore.domain.Book;
import com.seek.bookstore.web.CriteriaBook;
import com.seek.bookstore.web.Page;

import java.util.List;

/**
 * Created by ${Seek} on 2017/2/15
 */
public interface BookDAO {

	/**
	 * 根据id获取指定的book对象
	 *
	 * @param id
	 * @return
	 */
	Book getBook(int id);

	/**
	 * 根据传入的 CriteriaBook 对象返回对应的 Page 对象
	 *
	 * @param criteriaBook
	 * @return
	 */
	Page getPage(CriteriaBook criteriaBook);

	/**
	 * 根据传入的 CriteriaBook 对象返回其对应的记录数
	 *
	 * @param criteriaBook
	 * @return
	 */
	long getTotalBookNumber(CriteriaBook criteriaBook);


	/**
	 * 根据传入的 CriteriaBook 和 pageSize 返回当前页对应的 List
	 *
	 * @param criteriaBook
	 * @param pageSize
	 * @return
	 */
	List<Book> getPageList(CriteriaBook criteriaBook, int pageSize);

	/**
	 * 返回指定 id 的 book 的 storeNumber 字段的值
	 *
	 * @param id
	 * @return
	 */
	int getStoreNumber(Integer id);


	//* 根据传入的 ShoppingCartItem 的集合,

	//* 批量更新 books 数据表的 storenumber 和 salesnumber 字段的值

	//void batchUpdateStoreNumberAndSalesAmount(
	//		Collection<ShoppingCartItem> items);

}
