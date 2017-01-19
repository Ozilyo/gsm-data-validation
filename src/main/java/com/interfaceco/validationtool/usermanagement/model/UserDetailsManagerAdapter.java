package com.interfaceco.validationtool.usermanagement.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsManagerAdapter implements UserDetails {

	private Account account;
	private String password;

	public UserDetailsManagerAdapter(Account account) {
		this.account = account;
	}

	public Long getId() {
		return account.getId();
	}

	public String getFirstName() {
		return account.getFirstName();
	}

	public String getLastName() {
		return account.getLastName();
	}

	public String getFullName() {
		return account.getFullName();
	}

	public String getEmail() {
		return account.getEmail();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		
		for (Role role : account.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return account.isEnabled();
	}

}
