package com.interfaceco.validationtool.gsmparams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interfaceco.validationtool.gsmparams.model.Cell;
import com.interfaceco.validationtool.gsmparams.repository.CellRepository;

@Service
public class CellService {
	
	@Autowired
	private CellRepository cellRepository;
	
	public void addCell(Cell cell){
		cellRepository.save(cell);
	}
	
	public void updateCells(ArrayList<Cell> cells){
		cellRepository.save(cells);
	}
	
	public Cell getCellById(long cellId) {
		return cellRepository.findOne(cellId);
	}
	
	public Set<Cell> searchByCellName(String cellName){
		return cellRepository.findByCellNameContaining(cellName);
	}
	
	public List<Cell> listAllCells(){
		return cellRepository.findAll();
	}
	
	public List<Cell> listCellsInSite(Integer siteId){
		return cellRepository.findBySiteId(siteId);
	}
}
