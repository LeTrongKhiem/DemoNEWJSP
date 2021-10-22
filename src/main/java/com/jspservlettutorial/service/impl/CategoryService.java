package com.jspservlettutorial.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.jspservlettutorial.dao.ICategoryDAO;
import com.jspservlettutorial.dao.impl.CategoryDAO;
import com.jspservlettutorial.model.CategoryModel;
import com.jspservlettutorial.service.ICaregoryService;

public class CategoryService implements ICaregoryService {
//	private ICategoryDAO categoryDAO;
//
//	public CategoryService() {
//		categoryDAO = new CategoryDAO();
//	}

	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}
