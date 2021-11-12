package com.jspservlettutorial.dao;

import java.util.List;

import com.jspservlettutorial.mapper.RowMapper;

public interface GenericDAO<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);// câu sql , giá trị trả về, giá trị
    // tham số trong query không phải chỉ có
    // 1

    void update(String sql, Object... parameter);

    Long insert(String sql, Object... parameter);

    int count(String sql, Object... parameters);
}
