package com.seek.bookstore.servlet;

import com.google.gson.Gson;
import com.seek.bookstore.domain.Book;
import com.seek.bookstore.domain.ShoppingCart;
import com.seek.bookstore.service.BookService;
import com.seek.bookstore.web.BookStoreWebUtils;
import com.seek.bookstore.web.CriteriaBook;
import com.seek.bookstore.web.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${Seek} on 2017/2/23
 */
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

	private BookService bookService = new BookService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String methodName = req.getParameter("method");

		try {
			Method method = getClass().getDeclaredMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void updateItemQuantity(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//4. 在 updateItemQuantity 方法中, 获取 quantity, id, 再获取购物车对象, 调用 service 的方法做修改
		String idStr = req.getParameter("id");
		String quantityStr = req.getParameter("quantity");

		ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(req);

		int id = -1;
		int quantity = -1;

		try {
			id = Integer.parseInt(idStr);
			quantity = Integer.parseInt(quantityStr);
		} catch (NumberFormatException e) {}

		if (id > 0 && quantity > 0) {
			bookService.updateItemQuantity(shoppingCart, id, quantity);
		}

		//5. 传回 JSON 数据: bookNumber:xx, totalMoney
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("bookNumber", shoppingCart.getBookNumber());
		resultMap.put("totalMoney", shoppingCart.getTotalMoney());

		Gson gson = new Gson();
		String jsonStr = gson.toJson(resultMap);
		resp.setContentType("text/javascript");
		resp.getWriter().print(jsonStr);

	}

	/**
	 * 删除购物车内的一条记录
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void remove(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String idStr = req.getParameter("id");

		int id = -1;

		id = Integer.parseInt(idStr);
		ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(req);
		bookService.removeItemFromShoppingCart(shoppingCart, id);

		if (shoppingCart.isEmpty()) {
			req.getRequestDispatcher("WEB-INF/pages/emptycart.jsp").forward(req, resp);
			return;
		}

		req.getRequestDispatcher("WEB-INF/pages/cart.jsp").forward(req, resp);

	}

	/**
	 * 清空购物车
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void clearShoppingCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(req);

		bookService.clearShopping(shoppingCart);
		req.getRequestDispatcher("WEB-INF/pages/emptycart.jsp").forward(req, resp);
	}

	/**
	 * 去购物车页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toCartPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/pages/cart.jsp").forward(req, resp);
	}


	/**
	 * 查看购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void forwardPage(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 加入购物车
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addToCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean flag = false;

		//1.获取商品的id
		String idStr = request.getParameter("id");
		int id = -1;

		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {}

		if (id > 0) {
			//2.获取购物车对象
			ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(request);

			//3.调用BookService的addToCart方法把商品放入到购物车中
			flag = bookService.addToCart(id, shoppingCart);
		}

		if (flag) {
			//4.直接调用getBooks()方法
			getBooks(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath() + "/error-2.jsp");

		//response.sendRedirect(request.getContextPath() + "/error-1.jsp");
	}

	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = -1;

		Book book = null;

		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {}

		if (id > 0) {
			book = bookService.getBook(id);
		}

		if (book == null) {
			response.sendRedirect(request.getContextPath() + "/error-1.jsp");
			return;
		}

		request.setAttribute("book", book);
		request.getRequestDispatcher("/WEB-INF/pages/book.jsp").forward(request, response);
	}

	protected void getBooks(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {

		String pageNoStr = request.getParameter("pageNo");
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");

		int pageNo = 1;
		int minPrice = 0;
		int maxPrice = Integer.MAX_VALUE;

		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (Exception e) {
		}

		try {
			minPrice = Integer.parseInt(minPriceStr);
		} catch (Exception e) {
		}

		try {
			maxPrice = Integer.parseInt(maxPriceStr);
		} catch (Exception e) {
		}


		CriteriaBook criteriaBook = new CriteriaBook(minPrice, maxPrice, pageNo);
		Page<Book> bookPage = bookService.getPage(criteriaBook);
		request.setAttribute("bookPage", bookPage);
		//TODO 因为使用请求的转发，导致每刷新一次购物车数量加1 ，重复提交。
		request.getRequestDispatcher("/WEB-INF/pages/books.jsp").forward(request, response);
	}
}
