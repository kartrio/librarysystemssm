package com.library.model;

/**
 * 管理員信息实体类
 * 
 * @author Administrator
 *
 */
public class Manager{
	private int id;
	private String name;
	private String PWD;

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

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String PWD) {
		this.PWD = PWD;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", PWD=" + PWD + "]";
	}

}
