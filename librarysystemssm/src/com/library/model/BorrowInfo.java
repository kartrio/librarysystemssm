package com.library.model;

/**
 * 借阅书籍信息实体类
 * 
 * @author Administrator
 *
 */
public class BorrowInfo {
	private int id;
	private String borrowTime;
	private String backTime;
	private String operator;
	private int ifback;
	private int status; // 处理
	private ReaderInfo readerInfo;
	private BookInfo bookInfo;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(String borrowTime) {
		this.borrowTime = borrowTime;
	}

	public String getBackTime() {
		return backTime;
	}

	public void setBackTime(String backTime) {
		this.backTime = backTime;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getIfback() {
		return this.ifback;
	}

	public void setIfback(int ifback) {
		this.ifback = ifback;
	}

	public ReaderInfo getReaderInfo() {
		return this.readerInfo;
	}

	public void setReaderInfo(ReaderInfo readerInfo) {
		this.readerInfo = readerInfo;
	}

	public BookInfo getBookInfo() {
		return this.bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BorrowInfo [id=" + id + ", borrowTime=" + borrowTime + ", backTime=" + backTime + ", operator="
				+ operator + ", ifback=" + ifback + ", status=" + status + ", readerInfo=" + readerInfo + ", bookInfo="
				+ bookInfo + "]";
	}

}
