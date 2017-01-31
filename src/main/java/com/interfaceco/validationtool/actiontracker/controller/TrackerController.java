package com.interfaceco.validationtool.actiontracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.interfaceco.validationtool.actiontracker.service.CellRevisionService;

@Controller
@RequestMapping("action-tracker")
public class TrackerController {
	
	@Autowired
	private CellRevisionService cellRevisionService;
	
	@GetMapping(value="/cell/{cellId}")
	public String getLastEdits(@PathVariable("cellId") Integer cellId, Model model){
		model.addAttribute("cellVersions", cellRevisionService.getAllVersionsForCell(cellId));
		
		model.addAttribute("revisionEntities", cellRevisionService.getAllRivisionForEntity(cellId));
		model.addAttribute("cellId", cellId);
		return "actiontracker/cell-tracker";
	}
	
	@GetMapping("/cell/{cellId}/{revNum}")
	public String getEditForRevisionNumber(@PathVariable("cellId") Integer cellId, @PathVariable("revNum") Integer revNum, Model model){
		System.err.println(cellId + " "+ revNum);
		model.addAttribute("cellNew", cellRevisionService.getCellEditedInRevision(revNum, cellId));
		model.addAttribute("cellOld", cellRevisionService.getCellEditedInRevision(revNum-1, cellId));
		return "actiontracker/cell-version";
	}
}
