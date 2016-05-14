package com.fly.bean;

import java.util.List;

/**��ҳ������
 * @author ����
 *
 */
public class Pager {

	/**
	 * ��ǰҳ��
	 */
	private int pageNumber;
	
    /**
     * ÿҳ��¼����
     */
    private int pageSize;
    
    /**
     * ҳ��
     */
    private int pageCount;
    
    /**
     * ��¼��
     */
    private Long recordCount;
    
    /**
     * ��Ų�ѯ����
     */
    private List<?> list;

	/**Pager��Ψһ���캯��
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
