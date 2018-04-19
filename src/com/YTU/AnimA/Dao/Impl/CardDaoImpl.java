package com.YTU.AnimA.Dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.YTU.AnimA.Dao.CardDao;
import com.YTU.AnimA.entity.Card;
/**
 * 该类引用了CardDao接口用于对Card进行增删改查操作，函数操作要求请查看CardDao.java文件
 */
public class CardDaoImpl implements CardDao {

	@Override
	public void save(Connection connection, Card card) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Connection connection, Long id, Card card) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Connection connection, Card card) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultSet get(Connection connection, Card card) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
