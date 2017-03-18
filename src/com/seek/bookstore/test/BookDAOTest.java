package com.seek.bookstore.test;

import com.seek.bookstore.dao.BookDAO;
import com.seek.bookstore.domain.Book;
import com.seek.bookstore.impl.BookDAOImpl;
import com.seek.bookstore.web.CriteriaBook;
import com.seek.bookstore.web.Page;
import org.junit.Test;

/**
 * Created by ${Seek} on 2017/2/15
 */
public class BookDAOTest {

	BookDAO bookDAO = new BookDAOImpl();

	@Test
	public void getBookTest() {
		Book book = bookDAO.getBook(6);
		System.out.println(book);
	}

	@Test
	public void getPageTest() {
		CriteriaBook criteriaBook = new CriteriaBook(0,Integer.MAX_VALUE,1);
		System.out.println(criteriaBook.getPageNo());
		Page<Book> bookPage = bookDAO.getPage(criteriaBook);
		System.out.println( "pageNo:" + bookPage.getPageNo());
		System.out.println("List"+bookPage.getList());
		System.out.println("totalPageNumber"+bookPage.getTotalPageNumber());
		System.out.println("nextPage"+bookPage.getNextPage());
		System.out.println( "prePage"+ bookPage.getPrePage());
		System.out.println( "pageSize" + bookPage.getPageSize());

	}
}
