package com.interfaceco.validationtool.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interfaceco.validationtool.usermanagement.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
