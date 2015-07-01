package com.mexp.core.base;

/**
 * 
 * @author allennb
 *
 */
public class BaseQuery implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -610954131828728454L;

	/** The sort columns. */
	private String sortColumns;
	
	/** The offset. */
	private long offset;
	
	/** The page size. */
	private long pageSize;
	
	/** The last rows. */
	private long lastRows;
	
	private Boolean queryShowAll = false;
	
	/**
	 * Gets the sort columns.
	 *
	 * @return the sort columns
	 */
	public String getSortColumns() {
		return sortColumns;
	}
	
	/**
	 * Sets the sort columns.
	 *
	 * @param sortColumns the new sort columns
	 */
	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}
	
	/**
	 * Gets the offset.
	 *
	 * @return the offset
	 */
	public long getOffset() {
		return offset;
	}
	
	/**
	 * Sets the offset.
	 *
	 * @param offset the new offset
	 */
	public void setOffset(long offset) {
		this.offset = offset;
	}
	
	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public long getPageSize() {
		return pageSize;
	}
	
	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * Gets the last rows.
	 *
	 * @return the last rows
	 */
	public long getLastRows() {
		return lastRows;
	}
	
	/**
	 * Sets the last rows.
	 *
	 * @param lastRows the new last rows
	 */
	public void setLastRows(long lastRows) {
		this.lastRows = lastRows;
	}

	public Boolean getQueryShowAll() {
		return queryShowAll;
	}

	public void setQueryShowAll(Boolean queryShowAll) {
		this.queryShowAll = queryShowAll;
	}
	
}
