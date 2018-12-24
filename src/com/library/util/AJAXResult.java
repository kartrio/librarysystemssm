package com.library.util;

/**
 * AJAX返回信息实体类
 * @author Administrator
 *
 */
public class AJAXResult {
	private boolean success;
	private Object data;

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
