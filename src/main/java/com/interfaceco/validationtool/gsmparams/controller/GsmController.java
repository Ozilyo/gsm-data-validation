package com.interfaceco.validationtool.gsmparams.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.interfaceco.validationtool.gsmparams.model.Cell;
import com.interfaceco.validationtool.gsmparams.model.CellsListWrapper;
import com.interfaceco.validationtool.gsmparams.model.Site;
import com.interfaceco.validationtool.gsmparams.service.CellService;
import com.interfaceco.validationtool.gsmparams.service.SiteService;

@Controller
public final class GsmController {

	@Autowired
	private SiteService siteService;

	@Autowired
	private CellService cellService;

	private ArrayList<CellsListWrapper> allCellsInForm = new ArrayList<CellsListWrapper>();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("site", new Site());
		model.addAttribute("siteList", siteService.listAllSites());
		return "cell-level";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("site", new Site());
		model.addAttribute("siteList", siteService.listAllSites());
		return "welcome";
	}

	@RequestMapping(value = "/sites/search")
	public String searchSites(@RequestParam("siteName") String siteName, Model model) {
		model.addAttribute("site", new Site());
		model.addAttribute("siteList", siteService.searchBySiteName(siteName));
		return "sites-found";
	}

	@RequestMapping(value = "/site/{siteId}")
	public String displayDataEntryForm(@PathVariable("siteId") long id, Model model) {

		CellsListWrapper wrapper = new CellsListWrapper();
		wrapper.setCellList((ArrayList<Cell>) cellService.listCellsInSite((int) id));
		System.err.println(wrapper.getCellList().get(1));
		
		model.addAttribute("wrapper", wrapper);	
		model.addAttribute("site", siteService.getSiteBySiteId(id));
//		model.addAttribute("cellsList", cellService.listCellsInSite((int) id));
//		 model.addAttribute("cell", new Cell());
		return "cell-level";
	}
	
	@RequestMapping(value="/cell/submitQuery",  method=RequestMethod.POST)
	public String editCells(@ModelAttribute CellsListWrapper wrapper, Model model){
		cellService.updateCells(wrapper.getCellList());
		model.addAttribute(wrapper);
		return "redirect:/welcome";
	}
	
	@RequestMapping(value = "/site/edit/{siteId}")
	public String displaySiteProfile(@PathVariable("siteId") int id, Model model){
		model.addAttribute("site", siteService.getSiteBySiteId((long) id));
		return "site-profile";
	}
	
	
	public String editSite(){
		return null;
	}
}
