package com.library.model;

import java.util.Date;

/**
 * 归还书籍信息实体类
 * 
 * @author Administrator
 *
 */
public class GiveBackInfo {
	private int id;
	private Date backTime;
	private String operator;
	private int status;
	private ReaderInfo readerInfo;
	private BookInfo bookInfo;
	private BorrowInfo borrowInfo;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBackTime() {
		return this.backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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

	public BorrowInfo getBorrowInfo() {
		return borrowInfo;
	}

	public void setBorrowInfo(BorrowInfo borrowInfo) {
		this.borrowInfo = borrowInfo;
	}

	@Override
	public String toString() {
		return "GiveBackInfo [id=" + id + ", backTime=" + backTime + ", operator=" + operator + ", status=" + status
				+ ", readerInfo=" + readerInfo + ", bookInfo=" + bookInfo + ", borrowInfo=" + borrowInfo + "]";
	}

}
