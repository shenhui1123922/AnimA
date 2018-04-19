package com.YTU.AnimA.entity;

/**
 * ProcessConfig类对应数据库中的ProcessConfig表，意为工序表。
 * 由于实际存在，所以同样视为实体类，同时也代表不可能有两个完全相同的工序，故ProcessConfig类继承了IdEntity类
 * 工序存在名称和回报，即用于描述工序和记录完成一道工序所应得的报酬。
 * @author Administrator
 *
 */
public class ProcessConfig extends IdEntity {
	String name;		//工序名
	double reward;		//工序回报

	public ProcessConfig() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		return "ProcessConfig [name=" + name + ", reward=" + reward + ", id=" + id + "]";
	}
}
