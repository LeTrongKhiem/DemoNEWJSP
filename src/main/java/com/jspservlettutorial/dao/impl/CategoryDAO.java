package com.jspservlettutorial.dao.impl;

import java.util.List;

import com.jspservlettutorial.dao.ICategoryDAO;
import com.jspservlettutorial.mapper.CategoryMapper;
import com.jspservlettutorial.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());

	}

}
