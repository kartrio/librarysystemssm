package com.library.model;

/**
 * 申请借书证信息
 * 
 * @author Administrator
 *
 */
public class ApplyInfo {
	private int id;
	private int del; //处理意见: 0 -- 新建 , 1 -- 同意 , 2 -- 不同意
	private ReaderInfo readerInfo;
	private String operator;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public ReaderInfo getReaderInfo() {
		return readerInfo;
	}

	public void setReaderInfo(ReaderInfo readerInfo) {
		this.readerInfo = readerInfo;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "ApplyInfo [id=" + id + ", del=" + del + ", readerInfo=" + readerInfo + ", operator=" + operator + "]";
	}

}
