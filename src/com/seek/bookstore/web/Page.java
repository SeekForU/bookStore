package com.seek.bookstore.web;

import java.util.List;

/**
 * Created by ${Seek} on 2017/2/13
 */
public class Page<T> {

	//当前第几页
	private int pageNo;

	//此页面需要显示的List
	private List<T> list;

	//每页多少条记录
	private int pageSize = 3;

	//总记录数
	private long totalItemNumber;


	//初始化pageNo
	public Page(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageNo() {
		if (pageNo < 0) {
			pageNo = 1;
		}
		if (pageNo > getTotalPageNumber()) {
			pageNo = getTotalPageNumber();
		}
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	//获取总页数
	public int getTotalPageNumber() {

		int totalPageNumber = (int) (totalItemNumber / pageSize);
		if (totalItemNumber % pageSize != 0) {
			totalPageNumber++;
		}
		return totalPageNumber;
	}

	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	public boolean isHasNext() {
		if (getPageNo() < getTotalPageNumber()) {
			return true;
		}
		return false;
	}

	public boolean isHasPrev() {
		if (getPageNo() > 1) {
			return true;
		}
		return false;
	}

	public int getPrePage() {
		if (isHasPrev()) {
			return getPageNo() - 1;
		}
		return getPageNo();
	}

	public int getNextPage() {
		if (isHasNext()) {
			return getPageNo() + 1;
		}
		return getPageNo();
	}
}

