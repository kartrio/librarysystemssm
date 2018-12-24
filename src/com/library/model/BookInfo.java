package com.library.model;

import java.util.Date;

/**
 * 书籍信息实体类
 * @author Administrator
 *
 */
public class BookInfo {
	private int id;
	private String barcode;
	private String bookname;
	private String author;
	private String translator;
	private float price;
	private int page;
	private Date inTime;
	private String operator;
	private int del;
	
	private Bookcase bookcase;
	private PublishInfo publishInfo;
	private BookType bookType;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTranslator() {
		return this.translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Date getInTime() {
		return this.inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getDel() {
		return this.del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public BookType getBookType() {
		return this.bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public Bookcase getBookcase() {
		return this.bookcase;
	}

	public void setBookcase(Bookcase bookcase) {
		this.bookcase = bookcase;
	}

	public PublishInfo getPublishInfo() {
		return this.publishInfo;
	}

	public void setPublishInfo(PublishInfo publishInfo) {
		this.publishInfo = publishInfo;
	}

	public String toString() {
		return

		"BookInfo [id=" + this.id + ", barcode=" + this.barcode + ", bookname=" + this.bookname + ", author="
				+ this.author + ", translator=" + this.translator + ", price=" + this.price + ", page=" + this.page
				+ ", inTime=" + this.inTime + ", operator=" + this.operator + ", del=" + this.del + ", bookcase="
				+ this.bookcase + ", publishInfo=" + this.publishInfo + ", bookType=" + this.bookType + "]";
	}
}
