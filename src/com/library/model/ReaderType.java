package com.library.model;

/**
 * 读者类别信息实体类
 * @author Administrator
 *
 */
public class ReaderType {
	private int id;
	private String name;
	private int number;

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

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		return "ReaderType [id=" + this.id + ", name=" + this.name + ", number=" + this.number + "]";
	}
}
