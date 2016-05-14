package com.fly.bean;

import java.util.List;

/**分页工具类
 * @author 邓雷
 *
 */
public class Pager {

	/**
	 * 当前页号
	 */
	private int pageNumber;
	
    /**
     * 每页记录数量
     */
    private int pageSize;
    
    /**
     * 页数
     */
    private int pageCount;
    
    /**
     * 记录数
     */
    private Long recordCount;
    
    /**
     * 存放查询数据
     */
    private List<?> list;

	/**Pager的唯一构造函数
	 * @param pageNumber
	 * @param pageSize
	 * @param recordCount
	 * @param list
	 */
	public Pager(int pageNumber, int pageSize, Long recordCount, List<?> list) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.list = list;
		this.pageCount =  (int) Math.ceil((double) recordCount / pageSize);
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
    
}
