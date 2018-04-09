package top.gn.page;

import java.util.List;

public class Page<E> {

	
	//每一页显示的数量
	private int pageSize = 5;
	
	//当前页
	private int pageNo = 1;
	
	//总记录数
	private long totalItemsNumber;
	
	//当前页要显示的内容
	private List<E> list;
	
	public Page(int pageSize, int pageNo, int totalItemsNumber, List<E> list) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalItemsNumber = totalItemsNumber;
		this.list = list;
	}
	
	public Page(int pageSize, int pageNo, long totalItemsNumber) {
		super();
		this.pageSize = pageSize;
		this.pageNo = pageNo;
		this.totalItemsNumber = totalItemsNumber;
	}

	public Page(int pageNo) {
		this.pageNo = pageNo;
	}

	/* get set ... */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getPageNo() {
		if(pageNo<=0) {
			this.pageNo = 1;
		}
		
		if( pageNo > getTotalPageNumber()) {
			this.pageNo = (int)getTotalPageNumber();
		}
		
		if(totalItemsNumber == 0)
			return 1; 
		
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public List<E> getList() {
		return list;
	}
	
	public void setList(List<E> list) {
		this.list = list;
	}
	
	public long getTotalPageNumber() {
		//总页数
		long totalPageNumber = this.totalItemsNumber % this.pageSize == 0 ? this.totalItemsNumber / this.pageSize : (this.totalItemsNumber / this.pageSize) + 1;
		
		return totalPageNumber;
	}
	
	public void setTotalItemsNumber(long totalItemsNumber) {

		this.totalItemsNumber = totalItemsNumber;
	}
	
	public long getTotalItemsNumber() {
		return totalItemsNumber;
	}

	//是否有下一页
	public boolean isHasNext() {
		if(getPageNo() < getTotalPageNumber()) {
			return true;
		}
		return false;
	}
	//是否有上一页
	public boolean isHasPrev() {
		if(getPageNo() > 1) {
			return true;
		}
		return false;
	}

	//返回判断上一页的结果 , 将isHasPrev封装一下 增加一个get 方便EL 操作
	public boolean getIsHasPrev() {
		return isHasPrev();
	}
	public boolean getIsHasNext() {
		return isHasNext();
	}

	//返回上一页的页数
	public int getPrevPage() {
		if(isHasPrev()) {
			return getPageNo() - 1;
		}
		return getPageNo();
	}
	//返回下一页的页数
	public int getNextPage() {
		if(isHasNext()) {
			return getPageNo() + 1;
		}
		return getPageNo();
	}
	
	
	
}
