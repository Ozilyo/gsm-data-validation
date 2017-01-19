package com.interfaceco.validationtool.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.interfaceco.validationtool.usermanagement.dao.UserDetailsDao;
import com.interfaceco.validationtool.usermanagement.model.Account;
import com.interfaceco.validationtool.usermanagement.model.UserDetailsAdapter;

@Service("userDetailsService")
@Transactional(readOnly = true)
public class UserDetailsServiceAdapter implements UserDetailsService {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		Account account = accountService.getAccountByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("No such user: " + username);
		} else if (account.getRoles().isEmpty()) {
			throw new UsernameNotFoundException("User " + username + " has no authorities");
		}
		
		//authentication credentials (account + password = user -> (UserDetailsAdapter) )
		UserDetailsAdapter user = new UserDetailsAdapter(account);
		user.setPassword(userDetailsDao.findPasswordByUsername(username));
		
		return user;
	}

}
