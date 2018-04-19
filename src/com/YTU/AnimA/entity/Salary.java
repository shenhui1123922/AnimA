package com.YTU.AnimA.entity;

import java.sql.Date;

/**
 * Salary类对应数据库中的alary表，意为工资表。
 * 原则上讲，不允许出现两份完全相同的工资单，故Salary类继承了IdEntity类
 * @author Administrator
 *
 */
public class Salary extends IdEntity {
	String name;	//员工姓名
	Long emplyId;	//员工号
	Date payDay;	//发工资的日子
	double salary;	//经过计算算得的总报酬

	public Salary() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmplyId() {
		return emplyId;
	}

	public void setEmplyId(Long emplyId) {
		this.emplyId = emplyId;
	}

	public Date getPayDay() {
		return payDay;
	}

	public void setPayDay(Date payDay) {
		this.payDay = payDay;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Salary [name=" + name + ", emplyId=" + emplyId + ", payDay=" + payDay.toString() + ", salary=" + salary + ", id="
				+ id + "]";
	}
}
