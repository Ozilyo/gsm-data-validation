package com.interfaceco.validationtool.gsmparams.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class CellsListWrapper {
	private ArrayList<Cell> cellList;

	public ArrayList<Cell> getCellList() {
		return cellList;
	}

	public void setCellList(ArrayList<Cell> cellList) {
		this.cellList = cellList;
	}
	
}
