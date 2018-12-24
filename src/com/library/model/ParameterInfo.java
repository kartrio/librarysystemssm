package com.library.model;

/**
 * 参数信息实体类
 * @author Administrator
 *
 */
public class ParameterInfo {
	private int id;
	private int cost;
	private int validity;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getValidity() {
		return this.validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public String toString() {
		return "ParameterInfo [id=" + this.id + ", cost=" + this.cost + ", validity=" + this.validity + "]";
	}
}
