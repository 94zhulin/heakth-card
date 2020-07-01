package com.jsg.dzfbhealthcard.model;
/**
 * 
* @ClassName: DataGrid 
* @Description: 分页信息 
* @author 绵阳金盛高软件有限公司 
* @date 2017年10月14日 下午10:37:58 
*
 */
public class DataGrid {
	private int page;// 当前页
	private int rows;// 每页显示记录数
	private String sort;// 排序字段名
	private String order;// 按什么排序(asc,desc)
	private String parm;  //模糊查询参数
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getParm() {
		return parm;
	}
	public void setParm(String parm) {
		this.parm = parm;
	}

}
