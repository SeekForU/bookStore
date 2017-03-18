package com.seek.bookstore.dao;

import com.seek.bookstore.domain.User;

/**
 * Created by ${Seek} on 2017/2/15
 */
public interface UserDAO {

	/**
	 * 根据用户名获取User对象
	 * @param name
	 * @return
	 */
	User getUser(String name);
}
