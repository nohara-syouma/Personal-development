package com.example.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Enitity.BuyList;
import com.example.Enitity.Products;
import com.example.Enitity.User;
import com.example.dao.ProductDao;
import com.example.util.ParamUtil;


@Repository
public class PgProductDao implements ProductDao{
	
	 private static final String SELECT_ALL = "SELECT * FROM products";
	 private static final String ORDER_BY = " ORDER BY product_id";
	 
	 private static final String SQL_SELECT_FIND = "SELECT * FROM products WHERE";
	 private static final String SQL_SELECT_FINDID = "SELECT * FROM products WHERE product_id = :product_id";
	 
	 private static final String SQL_SELECT_USER = "SELECT * FROM list WHERE username = :username";
	 
	 private static final String DELETE = "DELETE FROM products WHERE product_id = :product_id";
	 
	 @Autowired
	 private NamedParameterJdbcTemplate jdbcTemplate;
	 
	 @Autowired
		HttpSession session;
	 
	 @Override
	 public List<Products> findAll() {
	       String sql = SELECT_ALL + ORDER_BY;
	       return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Products>(Products.class));
	    }
	 
	 @Override
	 public List<Products> find(Products products) {
		 
		 ArrayList<String> conditionList = new ArrayList<>();
		 
		 String productName = null;
	     
	     if (products != null) {
	            productName = products.getName();
	            System.out.println(productName);
	        }
	     
	     if (ParamUtil.isNullOrEmpty(productName)) {
	            return findAll();
	        }
	     
	     MapSqlParameterSource param = new MapSqlParameterSource();
	     
	     if (!ParamUtil.isNullOrEmpty(productName)) {
	    	 
	            conditionList.add(" name LIKE :name"); 
	            String find1 = "%" + productName + "%";
	            param.addValue("name",find1);
	        }
	        
	        String whereString = String.join(" AND ", conditionList.toArray(new String[] {}));
	        
			String sql = SQL_SELECT_FIND + whereString + ORDER_BY;
			
			List<Products> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Products>(Products.class));
			
			return resultList.isEmpty() ? null : resultList;
		 
	    }
	 
	 @Override
	 public List<BuyList> finduserlist() {
	       String sql = SQL_SELECT_USER + ORDER_BY;
	       
	       User user = (User) session.getAttribute("user");
	       
	       MapSqlParameterSource param = new MapSqlParameterSource();
	       System.out.println(user.getName());
//	       String find1 = "'" + user.getName() + "'";
	       
	        param.addValue("username", user.getName());
	        System.out.println(sql);
	        List<BuyList> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<BuyList>(BuyList.class));
	       return resultList.isEmpty() ? null : resultList;
	    }
	 
	 @Override
	 public Products findid(Integer productId) {
		 String sql = SQL_SELECT_FINDID;
		 
		    MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("product_id", productId);
		 
	        List<Products> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Products>(Products.class));

	        return resultList.isEmpty() ? null : resultList.get(0);
	 }
	 
		public int delete(Products products) {
			
			MapSqlParameterSource param = new MapSqlParameterSource();
			
			param.addValue("product_id",products.getProductId());
			
			String sql = DELETE;
			
			return jdbcTemplate.update(sql, param);
			
		}
}
