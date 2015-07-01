package com.mexp.core.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 分页
 */
public class Page<T> implements Serializable {
	
	//-- 公共变量 --//
		public static final String ASC = "asc";
		public static final String DESC = "desc";

		//-- 分页参数 --//
		protected int pageNo = 1;
		protected int pageSize = 10;
		protected String orderBy = null;
		protected String order = null;
		protected boolean autoCount = true;

		//-- 返回结果 --//
		protected List<T> result = new ArrayList();
		protected long totalCount = -1;

		//-- 构造函数 --//
		public Page() {
		}

		public Page(int pageSize) {
			this.pageSize = pageSize;
		}

		//-- 分页参数访问函数 --//
		/**
		 * 获得当前页的页号,序号从1开始,默认为1.
		 */
		public int getPageNo() {
			return pageNo;
		}

		/**
		 * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
		 */
		public void setPageNo(final int pageNo) {
			this.pageNo = pageNo;

			if (pageNo < 1) {
				this.pageNo = 1;
			}
		}

		/**
		 * 返回Page对象自身的setPageNo函数,可用于连续设置。
		 */
		public Page<T> pageNo(final int thePageNo) {
			setPageNo(thePageNo);
			return this;
		}

		/**
		 * 获得每页的记录数量, 默认为-1.
		 */
		public int getPageSize() {
			return pageSize;
		}

		/**
		 * 设置每页的记录数量.
		 */
		public void setPageSize(final int pageSize) {
			this.pageSize = pageSize;
		}

		/**
		 * 返回Page对象自身的setPageSize函数,可用于连续设置。
		 */
		public Page<T> pageSize(final int thePageSize) {
			setPageSize(thePageSize);
			return this;
		}

		/**
		 * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
		 */
		public long getCurrentFirst() {
			return ((pageNo - 1) * pageSize) + 1;
		}
		
		/**
		 * 根据总记录数和当前页开始记录数计算当前页最后条记录在总结果集中的位置.
		 */
		public long getCurrentLast() {
			long fullPage = getCurrentFirst() + getPageSize() - 1;
			return getTotalCount() < fullPage ? getTotalCount() : fullPage;
		}

		/**
		 * 获得排序字段,无默认值. 多个排序字段时用','分隔.
		 */
		public String getOrderBy() {
			return orderBy;
		}

		/**
		 * 设置排序字段,多个排序字段时用','分隔.
		 */
		public void setOrderBy(final String orderBy) {
			this.orderBy = orderBy;
		}

		/**
		 * 返回Page对象自身的setOrderBy函数,可用于连续设置。
		 */
		public Page<T> orderBy(final String theOrderBy) {
			setOrderBy(theOrderBy);
			return this;
		}

		/**
		 * 获得排序方向, 无默认值.
		 */
		public String getOrder() {
			return order;
		}

		/**
		 * 设置排序方式向.
		 * 
		 * @param order 可选值为desc或asc,多个排序字段时用','分隔.
		 */
		public void setOrder(final String order) {
			String lowcaseOrder = StringUtils.lowerCase(order);

			//检查order字符串的合法值
			String[] orders = StringUtils.split(lowcaseOrder, ',');
			for (String orderStr : orders) {
				if (!StringUtils.equals(DESC, orderStr.trim()) && !StringUtils.equals(ASC, orderStr.trim())) {
					throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
				}
			}

			this.order = lowcaseOrder;
		}

		/**
		 * 返回Page对象自身的setOrder函数,可用于连续设置。
		 */
		public Page<T> order(final String theOrder) {
			setOrder(theOrder);
			return this;
		}

		/**
		 * 是否已设置排序字段,无默认值.
		 */
		public boolean isOrderBySetted() {
			return (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order));
		}

		/**
		 * 获得查询对象时是否先自动执行count查询获取总记录数, 默认为false.
		 */
		public boolean isAutoCount() {
			return autoCount;
		}

		/**
		 * 设置查询对象时是否自动先执行count查询获取总记录数.
		 */
		public void setAutoCount(final boolean autoCount) {
			this.autoCount = autoCount;
		}

		/**
		 * 返回Page对象自身的setAutoCount函数,可用于连续设置。
		 */
		public Page<T> autoCount(final boolean theAutoCount) {
			setAutoCount(theAutoCount);
			return this;
		}

		//-- 访问查询结果函数 --//

		/**
		 * 获得页内的记录列表.
		 */
		public List<T> getResult() {
			return result;
		}

		/**
		 * 设置页内的记录列表.
		 */
		public void setResult(final List<T> result) {
			this.result = result;
		}

		/**
		 * 获得总记录数, 默认值为-1.
		 */
		public long getTotalCount() {
			return totalCount;
		}

		/**
		 * 设置总记录数.
		 */
		public void setTotalCount(final long totalCount) {
			this.totalCount = totalCount;
			
			if(this.getTotalPages() < this.getPageNo()) {
				this.setPageNo((int)this.getTotalPages());
			}
		}

		/**
		 * 根据pageSize与totalCount计算总页数, 默认值为-1.
		 */
		public long getTotalPages() {
			if (totalCount < 0) {
				return -1;
			}

			long count = totalCount / pageSize;
			if (totalCount % pageSize > 0) {
				count++;
			}
			return count;
		}

		/**
		 * 是否还有下一页.
		 */
		public boolean isHasNext() {
			return (pageNo + 1 <= getTotalPages());
		}

		/**
		 * 取得下页的页号, 序号从1开始.
		 * 当前页为尾页时仍返回尾页序号.
		 */
		public int getNextPage() {
			if (isHasNext()) {
				return pageNo + 1;
			} else {
				return pageNo;
			}
		}

		/**
	     * 是否是首页（第一页），第一页页码为1
	     *
	     * @return 首页标识
	     */
		public boolean isFirstPage() {
			return pageNo == 1;
		}
		
		/**
	     * 是否是最后一页
	     *
	     * @return 末页标识
	     */
		public boolean isLastPage() {
			return pageNo >= getTotalPages();
		}
		/**
		 * 是否还有上一页.
		 */
		public boolean isHasPre() {
			return (pageNo - 1 >= 1);
		}

		/**
		 * 取得上页的页号, 序号从1开始.
		 * 当前页为首页时返回首页序号.
		 */
		public int getPrePage() {
			if (isHasPre()) {
				return pageNo - 1;
			} else {
				return pageNo;
			}
		}
		
		/**
	     * 得到用于多页跳转的页码
	     * @return 页码列表
	     */
		public List<Integer> getLinkPageNumbers() {
			
			int currentPageNumber = getPageNo();
			int lastPageNumber = (int) getTotalPages();
			int count = 5;
			int avg = count/2;
			
			int startPageNumber = currentPageNumber - avg;
			if(startPageNumber <= 0) {
				startPageNumber = 1;
			}
			
			int endPageNumber = startPageNumber + count - 1;
			if(endPageNumber > lastPageNumber) {
				for(int i=0; i<(endPageNumber - lastPageNumber); i++) {
					if((startPageNumber-1) <=0) {
						startPageNumber = 1;
						break;
					} else {
						startPageNumber--;
					}
				}
				
				endPageNumber = lastPageNumber;			
			}
			
			if(endPageNumber - startPageNumber < (count -1)) {
				startPageNumber = endPageNumber - count;
				if(startPageNumber <= 0 ) {
					startPageNumber = 1;
				}
			}
			
			java.util.List<Integer> result = new java.util.ArrayList();
			for(int i = startPageNumber; i <= endPageNumber; i++) {
				result.add(new Integer(i));
			}
			return result;
		}
		
		/**
		 * 取得分页参数的组合字符串.
		 * 将多个分页参数组合成一个字符串方便在页面上的传递,格式为pageNo|orderBy|order.
		 */
		public String getPageRequest() {
			return getPageNo() + "|" + StringUtils.defaultString(getOrderBy()) + "|" + getOrder();
		}

		/**
		 * 设置分页参数的组合字符串.
		 * 将多个分页参数组合成一个字符串方便在页面上的传递,格式为pageNo|orderBy|order.
		 */
		public void setPageRequest(final String pageRequest) {

			if (StringUtils.isBlank(pageRequest)) {
				return;
			}

			String[] params = StringUtils.splitPreserveAllTokens(pageRequest, '|');

			if (StringUtils.isNumeric(params[0])) {
				setPageNo(Integer.valueOf(params[0]));
			}

			if (StringUtils.isNotBlank(params[1])) {
				setOrderBy(params[1]);
			}

			if (StringUtils.isNotBlank(params[2])) {
				setOrder(params[2]);
			}
		}
		
		public void setTotalPages(int totalPages) {
			
		}
		public void setPrePage(int prePage) {
			
		}
		public void setNextPage(int nextPage) {
			
		}
		
		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}
}

