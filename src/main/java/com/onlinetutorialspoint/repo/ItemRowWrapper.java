package com.onlinetutorialspoint.repo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.onlinetutorialspoint.model.Item;

public class ItemRowWrapper implements RowMapper<Item> {
	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Item item=new Item();
		item.setId(rs.getInt("ID"));
		item.setName(rs.getString("NAME"));
		item.setCategory(rs.getString("CATEGORY"));
		return item;
	}

}
