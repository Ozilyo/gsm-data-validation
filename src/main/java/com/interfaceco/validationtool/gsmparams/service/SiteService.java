package com.interfaceco.validationtool.gsmparams.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interfaceco.validationtool.gsmparams.model.Site;
import com.interfaceco.validationtool.gsmparams.repository.SiteRepository;

@Service
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
	
	public void addSite(Site site){
		siteRepository.save(site);
	}
	
	public Site getSiteById(long siteId){
		return siteRepository.findOne(siteId);
	}
	
	public Set<Site> searchBySiteName(String siteName){
		return siteRepository.findBySiteNameContaining(siteName);
	}
	
	public List<Site> listAllSites(){
		return siteRepository.findAll();
	}

	public Site getSiteBySiteId(Long siteId) {
		return siteRepository.findBySiteId(siteId);
	}
	
}
