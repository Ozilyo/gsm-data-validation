package com.interfaceco.validationtool.gsmparams.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@RequestMapping(value="/")
	public String login (Model model){
		return "login";
	}
	
	@RequestMapping(value = "/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("site", new Site());
		model.addAttribute("siteList", siteService.listAllSites());
		return "cell-level2";
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
		return "welcome";
	}

	@RequestMapping(value = "/site/{siteId}")
	public String displayDataEntryForm(@PathVariable("siteId") long id, Model model) {
		Site site = siteService.getSiteBySiteId(id);
		CellsListWrapper wrapper = new CellsListWrapper();
		ArrayList<Cell> cells = new ArrayList<>(site.getCells());
		wrapper.setCellList(cells);
		
		model.addAttribute("wrapper", wrapper);	
		model.addAttribute("site", site);
//		model.addAttribute("cellsList", cellService.listCellsInSite((int) id));
//		model.addAttribute("cell", new Cell());
		return "cell-level2";
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
		return "site";
	}
	
	@PostMapping(value="/site/submitQuery")
	public String editSite(@ModelAttribute Site site, Model model){
		siteService.addSite(site);
		return "redirect:/welcome";
	}
	
	
}
