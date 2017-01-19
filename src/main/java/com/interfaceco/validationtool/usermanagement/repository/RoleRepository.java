package com.interfaceco.validationtool.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interfaceco.validationtool.usermanagement.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRoleName(String roleName);
}
