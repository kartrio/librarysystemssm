package com.library.model;

/**
 * 图书馆信息实体类
 * 
 * @author Administrator
 *
 */
public class LibraryInfo {
	private int id;
	private String libraryname;
	private String curator;
	private String tel;
	private String address;
	private String email;
	private String url;
	private String createDate;
	private String introduce;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibraryname() {
		return this.libraryname;
	}

	public void setLibraryname(String libraryname) {
		this.libraryname = libraryname;
	}

	public String getCurator() {
		return this.curator;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String toString() {
		return "LibraryInfo [id=" + this.id + ", libraryname=" + this.libraryname + ", curator=" + this.curator
				+ ", tel=" + this.tel + ", address=" + this.address + ", email=" + this.email + ", url=" + this.url
				+ ", createDate=" + this.createDate + ", introduce=" + this.introduce + "]";
	}
}
