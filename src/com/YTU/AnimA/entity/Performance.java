package com.YTU.AnimA.entity;

import java.sql.Date;

/**
 * Performance类对应数据库中的Performance表，意为员工所持有的卡的绩效。
 * 卡号，工序号和日期的数据组在数据库表中是唯一的，所以无需继承IDEntity类，但需要在类成员中添加卡号和工序号
 * @author Administrator
 *
 */
public class Performance {

	Long pcId;		//工序号
	Long cardId;	//卡号
	Date oneday;	//日期，用于标记该条记录代表的绩效是哪一天的
	double reward;	//存储工序对应的回报。
	
	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	int cumulative;	//累计数，用于记录卡的绩效

	public Performance() {
		super();
	}

	public Date getOneday() {
		return oneday;
	}

	public void setOneday(Date oneday) {
		this.oneday = oneday;
	}

	public Long getPcId() {
		return pcId;
	}

	public void setPcId(Long pcId) {
		this.pcId = pcId;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	public int getCumulative() {
		return cumulative;
	}

	public void setCumulative(int cumulative) {
		this.cumulative = cumulative;
	}

	@Override
	public String toString() {
		return "Performance [pcId=" + pcId + ", cardId=" + cardId + ", oneday=" + oneday + ", reward=" + reward
				+ ", cumulative=" + cumulative + "]";
	}

}
