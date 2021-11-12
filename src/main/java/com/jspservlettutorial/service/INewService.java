package com.jspservlettutorial.service;

import java.util.List;

import com.jspservlettutorial.model.NewModel;

public interface INewService {
	List<NewModel> findByCategoryId(long categoryId);

	NewModel save(NewModel newModel);

	NewModel update(NewModel updateNews);

	void delete(long[] ids);

	List<NewModel> findAll(Integer offset, Integer limit);

	int getTotalItem();
}
