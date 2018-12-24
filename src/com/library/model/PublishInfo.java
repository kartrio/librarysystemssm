package com.library.model;

/**
 * 出版信息实体类
 * @author Administrator
 *
 */
public class PublishInfo {
	private String isbn;
	private String pubname;

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPubname() {
		return this.pubname;
	}

	public void setPubname(String pubname) {
		this.pubname = pubname;
	}

	public String toString() {
		return "PublishInfo [isbn=" + this.isbn + ", pubname=" + this.pubname + "]";
	}
}
