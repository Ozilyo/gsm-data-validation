package com.interfaceco.validationtool.usermanagement.dao;

public interface UserDetailsDao {
	String findPasswordByUsername(String username);
}
