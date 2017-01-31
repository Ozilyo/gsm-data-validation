package com.interfaceco.validationtool.usermanagement.service;

import org.springframework.validation.Errors;

import com.interfaceco.validationtool.usermanagement.model.Account;
import com.interfaceco.validationtool.usermanagement.validation.UsernameExistsException;


public interface AccountService {
	boolean registerAccount(Account account, String password, Errors errors) throws UsernameExistsException;
	
	Account getAccountByUsername(String username);

	String getCurrentUsername();
}
