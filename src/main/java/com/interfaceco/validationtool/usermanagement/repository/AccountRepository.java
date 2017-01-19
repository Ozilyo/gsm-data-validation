package com.interfaceco.validationtool.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.interfaceco.validationtool.usermanagement.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
	
	@Modifying
	@Query("update Account a set a.password = ?1 where a.username = ?2")
	void updateAccountWithPassword(String password, String username);
}
