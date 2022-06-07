package com.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Enitity.Products;
import com.example.dao.InsertDao;

@Repository
public class PgInsertDao implements InsertDao{
	
	private static final String INSERT = "INSERT INTO products (product_id, category_id, name, price) VALUES(:product_id, :category_id, :name, :price)";
	
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	 
	    @Override
	    public void insert(Products product) {
	        String sql = INSERT;

	        MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("product_id", product.getProductId());
	        param.addValue("category_id", product.getCategoryId());
	        param.addValue("name", product.getName());
	        param.addValue("price", product.getPrice());

	        jdbcTemplate.update(sql, param);
	    }

}
