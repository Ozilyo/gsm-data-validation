package com.interfaceco.validationtool.usermanagement.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.interfaceco.validationtool.usermanagement.model.Account;
import com.interfaceco.validationtool.usermanagement.repository.AccountRepository;
import com.interfaceco.validationtool.usermanagement.repository.RoleRepository;
import com.interfaceco.validationtool.usermanagement.validation.UsernameExistsException;

//@Service
//@Scope("prototype")
@Component
@Transactional(readOnly = true)
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean("passwordEncoder")
	public PasswordEncoder passwordEncoder(){
	    PasswordEncoder encoder = new BCryptPasswordEncoder();
	    return encoder;
	}
	
	
//	@Autowired
//	@Qualifier("passwordEncoder")
//    BCryptPasswordEncoder passwordEncoder;

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
			System.err.println(encodedPass);
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
	
	@Override
	public String getCurrentUsername(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.err.println(username);
		return username;
	}
}
