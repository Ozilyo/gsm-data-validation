package com.interfaceco.validationtool.gsmparams.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interfaceco.validationtool.gsmparams.model.Cell;
import com.interfaceco.validationtool.gsmparams.service.SiteService;

@Component
public class CellItemProcessor implements ItemProcessor<Cell, Cell> {

	
	@Autowired
	private SiteService siteService;
	
	@Override
	public Cell process(Cell cell) throws Exception {
		cell.setSite(siteService.getSiteBySiteId(cell.getSiteId()));
		return cell;
	}

}
