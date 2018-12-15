package com.library.model;

public class BookType {
	private int id;
	private String typename;
	private Integer days;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "BookType [id=" + id + ", typename=" + typename + ", days=" + days + "]";
	}

}
