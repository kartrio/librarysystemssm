package com.library.model;

/**
 * 书架信息实体类
 * @author Administrator
 *
 */
public class Bookcase {
	private int id;
	private String name;
	private String column_3;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumn_3() {
		return this.column_3;
	}

	public void setColumn_3(String column_3) {
		this.column_3 = column_3;
	}

	public String toString() {
		return "Bookcase [id=" + this.id + ", name=" + this.name + ", column_3=" + this.column_3 + "]";
	}
}
