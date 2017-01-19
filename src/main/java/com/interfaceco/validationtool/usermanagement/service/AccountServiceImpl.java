package com.interfaceco.validationtool.usermanagement.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.interfaceco.validationtool.usermanagement.model.Account;
import com.interfaceco.validationtool.usermanagement.repository.AccountRepository;
import com.interfaceco.validationtool.usermanagement.repository.RoleRepository;
import com.interfaceco.validationtool.usermanagement.validation.UsernameExistsException;

@Service
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Autowired
//    BCryptPasswordEncoder bcryptEncoder;

	@Override
	@Transactional(readOnly = false)
	public boolean registerAccount(Account account, String password, Errors errors) throws UsernameExistsException {
		validateUsername(account.getUsername(), errors);
		boolean valid = !errors.hasErrors();
		
		if (userNameExists(account.getUsername())){
			throw new UsernameExistsException("A user already exists with that username: " + account.getUsername());
		}
		
		
		if (valid) {
			account.setRoles(Arrays.asList(roleRepository.findByRoleName("ROLE_USER")));
			accountRepository.save(account);
			String encodedPass = passwordEncoder.encode(password);
			accountRepository.updateAccountWithPassword(encodedPass, account.getUsername());
		}
		return valid;
	}

	private void validateUsername(String username, Errors errors) {
		if (accountRepository.findByUsername(username) != null) {
			errors.rejectValue("username", "error.dublicate", new String[] { username }, null);
		}
	}

	@Override
	public Account getAccountByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	public boolean userNameExists(String username) {
		return accountRepository.findByUsername(username) != null;
	}
}
