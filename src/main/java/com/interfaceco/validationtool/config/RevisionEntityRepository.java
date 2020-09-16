package com.interfaceco.validationtool.config;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interfaceco.validationtool.actiontracker.revision.UserRevisionEntity;

public interface RevisionEntityRepository extends JpaRepository<UserRevisionEntity, Integer> {
	public List<UserRevisionEntity> findByUsernameContaining(String username);
	
}
