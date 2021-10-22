package com.jspservlettutorial.dao;

import java.util.List;

import com.jspservlettutorial.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findByCategoryId(long categoryId); // lấy các bài viết theo id của category

	Long save(NewModel newModel);

	void update(NewModel updateNew);

	NewModel findOne(Long id);

	void delete(long id);

	List<NewModel> findAll();
}
