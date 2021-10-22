package com.jspservlettutorial.dao;

import java.util.List;

import com.jspservlettutorial.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();

}
