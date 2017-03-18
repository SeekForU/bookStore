package com.seek.bookstore.dao;

import java.util.List;

/**
 * Created by ${Seek} on 2017/2/14
 * Dao 接口, 定义 Dao 的基本操作, 由 BaseDao 提供实现.
 * @param <T>: Dao 实际操作的泛型类型
 */
public interface DAO<T> {

	/**
	 * 执行插入操作，返回插入后的记录id
	 *
	 * @param sql  ：sql语句
	 * @param args ：填充占位符的可变参数
	 * @return：插入新记录的id
	 */
	long insert(String sql, Object... args);

	/**
	 * 执行UPDATE操作，包括insert(无返回值),update,delete
	 * @param sql:待执行的sql语句
	 * @param args:填充占位符的可变参数
	 */
	void update(String sql, Object... args);

	/**
	 * 执行单条的查询记录，返回与记录对应的类的一个对象
	 * @param sql:待执行的sql语句
	 * @param args:填充占位符的可变参数
	 * @return 和记录对应的一个类的对象
	 */
	T query(String sql, Object... args);

	/**
	 * 执行多条记录的查询，返回一个List
	 * @param sql:待执行的sql语句
	 * @param args : 填充占位符的可变参数
	 * @return:返回查询结果对应的一个List
	 */
	List<T> queryForList(String sql, Object... args);

	/**
	 * 执行一个属性或值的查询操作，例如查询某条记录的一个字段，或查询某个统计信息，返回要查询的值
	 * @param sql:待执行的sql语句
	 * @param args:填充占位符的可变参数
	 * @param <V>
	 * @return :执行一个属性或值的查询操作, 例如查询某一条记录的一个字段, 或查询某个统计信息, 返回要查询的值
	 */
	<V> V getSingleVal(String sql, Object... args);


	/**
	 * 执行批量更新操作
	 * @param sql:待执行的sql语句
	 * @param params:填充占位符的可变参数
	 */
	void batch(String sql,  Object[]... params);

}
