package com.library.model;

/**
 * 读者信息实体类
 * 
 * @author Administrator
 *
 */
public class ReaderInfo {
	private int id;
	private String name;
	private String pwd;
	private String sex;
	private String barcode;
	private String vocation;
	private String birthday;
	private String paperType;
	private String paperNO;
	private String tel;
	private String email;
	private String createDate;
	private String operator;
	private String status;
	private String remark;
	private ReaderType readerType;

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

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getVocation() {
		return this.vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	public String getPaperType() {
		return this.paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getPaperNO() {
		return this.paperNO;
	}

	public void setPaperNO(String paperNO) {
		this.paperNO = paperNO;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ReaderType getReaderType() {
		return this.readerType;
	}

	public void setReaderType(ReaderType readerType) {
		this.readerType = readerType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReaderInfo [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", barcode=" + barcode
				+ ", vocation=" + vocation + ", birthday=" + birthday + ", paperType=" + paperType + ", paperNO="
				+ paperNO + ", tel=" + tel + ", email=" + email + ", createDate=" + createDate + ", operator="
				+ operator + ", status=" + status + ", remark=" + remark + ", readerType=" + readerType + "]";
	}

}
