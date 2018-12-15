package com.library.model;

import java.util.Date;

/**
 * 归还书籍信息实体类
 * @author Administrator
 *
 */
public class GiveBackInfo {
	private int id;
	private Date backTime;
	private String operator;
	private ReaderInfo readerInfo;
	private BookInfo bookInfo;

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

	public String toString() {
		return "GiveBackInfo [id=" + this.id + ", backTime=" + this.backTime + ", operator=" + this.operator
				+ ", readerInfo=" + this.readerInfo + ", bookInfo=" + this.bookInfo + "]";
	}
}
