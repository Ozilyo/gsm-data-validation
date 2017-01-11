package com.interfaceco.validationtool.gsmparams.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interfaceco.validationtool.gsmparams.model.Cell;

public interface CellRepository extends JpaRepository<Cell, Long>{
	
	public Set<Cell> findByCellNameContaining(String cellName);

	public Set<Cell> findBySiteId(long siteId);
	
	
}
