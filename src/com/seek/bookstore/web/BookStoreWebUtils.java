package com.seek.bookstore.web;

import com.seek.bookstore.domain.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ${Seek} on 2017/2/26
 */
public class BookStoreWebUtils {


	/**
	 * 获取购物车对象: 从 session 中获取, 若 session 中没有改对象.
	 * 则创建一个新的购物车对象, 放入到 session 中.
	 * 若有, 则直接返回.
	 * @param request
	 * @return
	 */
	public static ShoppingCart getShoppingCart(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();


		ShoppingCart shoppingCart = (ShoppingCart) httpSession.getAttribute("shoppingCart");

		if (shoppingCart == null) {
			shoppingCart = new ShoppingCart();
			httpSession.setAttribute("shoppingCart", shoppingCart);
		}
		return shoppingCart;

	}

}
