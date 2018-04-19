package com.YTU.AnimA.entity;

import java.sql.Date;

/**
 * Employee类对应数据库中的employee表，意为员工表。
 * 由于员工为实体且不可出现两个相同的员工，故Employee类继承了IdEntity类
 * @author Administrator
 *
 */
public class Employee extends IdEntity {

	private String name;	//员工姓名
	private String sex;		//员工性别，m代表男性，f代表女性
	private String password;//员工密码，用于查询一些私人的员工信息
	private String email;	//员工的电子邮箱，用于通信和通知
	private Date birthday;	//员工生日，可用于计算员工的年龄
	private Date emplyDate;	//员工入职日期，可用于计算员工的工龄
	private Date cancelDate;//员工离职日期，可用于标记员工是否在职并计算工龄，为空则表示未离职

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getEmplyDate() {
		return emplyDate;
	}

	public void setEmplyDate(Date emplyDate) {
		this.emplyDate = emplyDate;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Employee() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", sex=" + sex + ", password=" + password + ", email=" + email + ", birthday="
				+ birthday.toString() + ", emplyDate=" + emplyDate.toString() + ", cancelDate=" + cancelDate.toString() + ", id=" + id + "]";
	}
}
