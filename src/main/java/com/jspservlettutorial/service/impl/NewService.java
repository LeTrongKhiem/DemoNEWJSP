package com.jspservlettutorial.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.jspservlettutorial.dao.INewDAO;
import com.jspservlettutorial.model.NewModel;
import com.jspservlettutorial.service.INewService;

public class NewService implements INewService {

    @Inject
    private INewDAO newDAO;

    @Override
    public List<NewModel> findByCategoryId(long categoryId) {
        // TODO Auto-generated method stub
        return newDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewModel save(NewModel newModel) {
        newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newModel.setCreatedBy("");
        Long newId = newDAO.save(newModel);
        return newDAO.findOne(newId);
    }

    @Override
    public NewModel update(NewModel updateNews) {
        NewModel oldNew = newDAO.findOne(updateNews.getId());
        updateNews.setCreatedDate(oldNew.getCreatedDate());
        updateNews.setCreatedBy(oldNew.getCreatedBy());
        updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        updateNews.setModifiedBy("");
        newDAO.update(updateNews);
        return newDAO.findOne(updateNews.getId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            newDAO.delete(id);
        }

    }

    @Override
    public List<NewModel> findAll() {
        return newDAO.findAll();
    }

}
