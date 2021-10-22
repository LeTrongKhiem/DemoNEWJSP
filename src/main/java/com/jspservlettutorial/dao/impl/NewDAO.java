package com.jspservlettutorial.dao.impl;

import com.jspservlettutorial.dao.INewDAO;
import com.jspservlettutorial.mapper.NewMapper;
import com.jspservlettutorial.model.NewModel;

import java.util.List;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

    @Override
    public List<NewModel> findByCategoryId(long categoryId) {
        String sql = "select * from news where categoryId = ?";
        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewModel newModel) {
        // String sql = "insert into news(title, content, categoryid, thumb)
        // values(?,?,?)";// câu sql
        StringBuilder sql = new StringBuilder("title, content,");
        sql.append(" thumbnail, shortdescripton, categoryid, createddate, createdby");
        sql.append("values(?,?,?,?,?,?,?)");
        return insert(sql.toString(), newModel.getTitle(), newModel.getContent(), newModel.getCategoryId(),
                newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCreatedDate(),
                newModel.getCreatedBy());

    }

    @Override
    public void update(NewModel updateNew) {
        StringBuilder sql = new StringBuilder("update news set title = ?, thumbnail = ?, ");
        sql.append("shortdescripton = ?, content = ?, categoryid = ?,");
        sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? where id = ?");
        update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
                updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), updateNew.getCreatedBy(),
                updateNew.getModifiedDate(), updateNew.getModifiedBy(), updateNew.getId());
    }

    @Override
    public NewModel findOne(Long id) {
        String sql = "select * from news where id = ?";
        List<NewModel> news = query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public void delete(long id) {
        String sql = "delete from news where id = ?";
        update(sql, id);

    }

    @Override
    public List<NewModel> findAll() {
        String sql = "select * from news";
        return query(sql, new NewMapper());
    }

}
