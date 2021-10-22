package com.jspservlettutorial.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspservlettutorial.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel category = new CategoryModel();
		try {
			category.setId(resultSet.getLong("id"));
			category.setCode(resultSet.getString("code"));
			category.setName(resultSet.getString("name"));
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}

	}

}
