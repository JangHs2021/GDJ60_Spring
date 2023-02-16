package com.iu.home.util;

public class PagerEx {
	// Pager
	// 10개 멤버변수 
	// 2개 지역변수
	// 1개 생성자 
	// 2개 메서드 생성
	// 2개 getPage 내용 추가
	private Long page;
	private Long perPage;
	private Long perBlock;
	private Long totalPage;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;
	private boolean after;
	private boolean before;
	
	public PagerEx() {
		perPage = 10L;
	}
	
	public void makeRow() {
		startRow = (getPage() - 1) * perPage + 1;
		lastRow = getPage() * perPage;
	}
	
	public void makeNum(Long totalCount) {
		
	}

	public Long getPage() {
		if(page == null || page < 1) {
			page = 1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		if(perBlock == null || perBlock < 1) {
			perBlock = 5L;
		}
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public boolean isBefore() {
		return before;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}
	
	// Search
	// 2개 멤버변수
	// 1개 getSearch 내용 추가
	
}
