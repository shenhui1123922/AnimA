package com.YTU.AnimA.entity;

/**
 * Card类对应数据库中的e_card表，意为卡片和员工号的对照。
 * 由于卡片拥有实体且不可出现两个相同的卡片，故Card类继承了IdEntity类
 * @author Administrator
 *
 */
public class Card extends IdEntity{
	
	private Long emplyId;	//卡片对应的员工ID

	public Long getEmplyId() {
		return emplyId;
	}

	public void setEmplyId(Long emplyId) {
		this.emplyId = emplyId;
	}

	public Card() {
		super();
	}

	@Override
	public String toString() {
		return "Card [emplyId=" + emplyId + ", cardId=" + id + "]";
	}
	
}
