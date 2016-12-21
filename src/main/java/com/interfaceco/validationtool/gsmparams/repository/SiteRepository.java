package com.interfaceco.validationtool.gsmparams.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interfaceco.validationtool.gsmparams.model.Site;

public interface SiteRepository extends JpaRepository<Site, Long> {
	
	public Set<Site> findBySiteNameContaining(String siteName);

	public Site findBySiteId(Long siteId);
}
