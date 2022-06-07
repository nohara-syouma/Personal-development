package com.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Enitity.User;
import com.example.dao.LoginDao;

@Repository
public class LoginDaoimpl implements LoginDao{
	
	private static final String SQL_SELECT_ID_AND_PASS = "SELECT * FROM users WHERE login_id = :login_id AND password = :password";
	
	private static final String INSERT = "INSERT INTO users (login_id, password, name, role) VALUES(:login_id, :password, :name, 2)";
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
		
		public User login(String id, String pass) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		param.addValue("login_id",id);
		param.addValue("password",pass);
		
		String sql = SQL_SELECT_ID_AND_PASS;
		
		List<User> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<User>(User.class));
		
		return  resultList.isEmpty() ? null : resultList.get(0);
		
	}
		
		@Override
	    public void logininsert(String id, String pass) {
	        String sql = INSERT;

	        MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("login_id", id);
	        param.addValue("password", pass);
	        param.addValue("name", id);

	        jdbcTemplate.update(sql, param);
	    }

}
