package util;
public class Pager {
	//一页多少条记录
	private int pageSize;
	//当前第几页
	private int currentPage;
	//总记录数
	private int totalCount;
	//总页数
	//得到前一页页码
	public int getPrevPage() {
		return currentPage==1?1:currentPage-1;
	}
	//得到前一页页码
	public int getNextPage() {
		return currentPage==totalPage?totalPage:currentPage+1;
	}
	private int totalPage;
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public Pager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
