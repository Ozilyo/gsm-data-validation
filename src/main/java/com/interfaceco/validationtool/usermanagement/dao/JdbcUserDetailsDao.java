package com.interfaceco.validationtool.usermanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserDetailsDao implements UserDetailsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String FIND_PASSWORD_SQL = "select password from account where username = ?";

	@Override
	public String findPasswordByUsername(String username) {
		return jdbcTemplate.queryForObject(FIND_PASSWORD_SQL, new Object[] { username }, String.class);
	}	

}
