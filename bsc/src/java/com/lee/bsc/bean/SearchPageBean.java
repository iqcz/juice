package com.lee.bsc.bean;

import java.util.List;
import java.util.Map;

public class SearchPageBean extends BIBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7754560766894861729L;

	private int page;

	private int pageSize;

	private int currentPageSize;

	private int totalPages;

	private int totalRecords;

	private boolean queryMissing = false;

	private Map<String, String> conditions;

	private List<?> pageRecords;

	private List<?> otherData;

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getCurrentPageSize() {
		return currentPageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public boolean isQueryMissing() {
		return queryMissing;
	}

	public Map<String, String> getConditions() {
		return conditions;
	}

	public List<?> getPageRecords() {
		return pageRecords;
	}

	public List<?> getOtherData() {
		return otherData;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPageSize(int currentPageSize) {
		this.currentPageSize = currentPageSize;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public void setQueryMissing(boolean queryMissing) {
		this.queryMissing = queryMissing;
	}

	public void setConditions(Map<String, String> conditions) {
		this.conditions = conditions;
	}

	public void setPageRecords(List<?> pageRecords) {
		this.pageRecords = pageRecords;
	}

	public void setOtherData(List<?> otherData) {
		this.otherData = otherData;
	}

}
