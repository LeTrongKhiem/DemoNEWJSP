package com.jspservlettutorial.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspservlettutorial.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		NewModel news = new NewModel();
		try {
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("shortdescripton"));
			news.setCreatedDate(resultSet.getTimestamp("createddate"));
			news.setCreatedBy(resultSet.getString("createdby"));
			if (resultSet.getTimestamp("modifieddate") != null) {
				news.setModifiedDate(resultSet.getTimestamp("modifieddate"));
			}
			if (resultSet.getTimestamp("modifiedby") != null) {
				news.setModifiedBy(resultSet.getString("modifiby"));
			}
			return news;
		} catch (SQLException e) {
			return null;
		}

	}

}
