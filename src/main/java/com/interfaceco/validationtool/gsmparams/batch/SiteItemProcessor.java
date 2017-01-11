package com.interfaceco.validationtool.gsmparams.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interfaceco.validationtool.gsmparams.model.Cell;
import com.interfaceco.validationtool.gsmparams.model.Site;
import com.interfaceco.validationtool.gsmparams.repository.SiteRepository;
import com.interfaceco.validationtool.gsmparams.service.SiteService;

@Component
public class SiteItemProcessor implements ItemProcessor<Site, Site> {
	
	@Autowired
	private SiteService siteService;
	
	@Override
	public Site process(Site site) throws Exception {
		System.err.println(site);
		siteService.addCellsToSite(site); 
		return site;
	}

}
