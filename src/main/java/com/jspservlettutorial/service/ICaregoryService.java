package com.jspservlettutorial.service;

import java.util.List;

import com.jspservlettutorial.model.CategoryModel;

public interface ICaregoryService {
	List<CategoryModel> findAll();
}
