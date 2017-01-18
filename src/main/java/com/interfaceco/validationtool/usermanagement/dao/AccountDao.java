package com.interfaceco.validationtool.usermanagement.dao;

import java.util.List;

import com.interfaceco.validationtool.usermanagement.model.Account;

public interface AccountDao {
	List<Account> findAll() throws Exception;
}
