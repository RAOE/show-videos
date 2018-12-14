package com.show.pojo;

import java.util.List;

public class PageResult {
private int page;
private int total;
private long records;
private List<?> rows;

public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public long getRecords() {
	return records;
}
public void setRecords(long records) {
	this.records = records;
}
public List<?> getRows() {
	return rows;
}
public void setRows(List<?> rows) {
	this.rows = rows;
}
@Override
public String toString() {
	return "PageResult [page=" + page + ", total=" + total + ", records=" + records + ", rows=" + rows + "]";
}


}
