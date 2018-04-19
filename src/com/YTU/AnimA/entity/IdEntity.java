package com.YTU.AnimA.entity;

/**
 * IdEntity类用于给拥有唯一标识主键（即为ID）的表所对应的实体类继承。
 * 
 * @author Administrator
 *
 */
public abstract class IdEntity {
	protected Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
}
