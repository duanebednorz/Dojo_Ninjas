package com.Duane.dojo.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Duane.dojo.models.Dojo;
import com.Duane.dojo.models.Ninjas;
import com.Duane.dojo.services.DojoNinjaService;


@Controller
public class HomeController {
	
	private DojoNinjaService dnServ;
	
	public HomeController(DojoNinjaService dnServ) {
		super();
		this.dnServ = dnServ;
	}
	
	@GetMapping("/dashboard")
	public String Dashboard(Model model) {
		model.addAttribute("allDojos", dnServ.getAllDojos());
		model.addAttribute("allNijas", dnServ.getAllNinjas());
		return "Dashboard.jsp";
	}
//	*******************************************************************
	@GetMapping("/dojos/new")
	public String NewDojo(Model model) {
		model.addAttribute("aDojo", new Dojo());
		return "NewDojo.jsp";
	}
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("aDojo") Dojo aDojo, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			System.out.println(result.getAllErrors());
		}else {
			dnServ.create(aDojo);
		// otherwise create a note and redirect back
		}
		return "redirect:/dashboard";
	}
//	*************************************************
	@GetMapping("/ninjas/new")
	public String NewNinja(Model model) {
		model.addAttribute("aNinja", new Ninjas());
		model.addAttribute("allDojos", dnServ.getAllDojos());
		return "NewNinja.jsp";
	}
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("aNinja") Ninjas aNinja, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			System.out.println(result.getAllErrors());
		}else {
			dnServ.create(aNinja);
		// otherwise create a note and redirect back
		}
		return "redirect:/dashboard";
	}
//	********************************************************
//	@GetMapping("/dojo/search/")
//	public String searchDojo(@RequestParam("dojo")String dojo, Model model) {
//	 	List<Dojo> ninjas = dnServ.searchBy(dojo);
//	 	model.addAttribute("ninjas",ninjas);
//	 	model.addAttribute("dojo",dojo);
//	 	System.out.println("**************");
//	 	return "ViewOne.jsp";
//	}
//	*****************************************	
	
	@GetMapping("/dojo/{id}/view")
	public String findOne(@PathVariable("id") Long id, Model model) {
    	Dojo myDojo = this.dnServ.findDojo(id);
    	model.addAttribute("thisDojo", myDojo);
    	return "ViewOne.jsp";
	}
//	*************************************************************
	@RequestMapping(value="/dojo/{id}/delete")
    public String delDojo(@PathVariable("id") Long id) {
        dnServ.deleteDojo(id);
        return "redirect:/dashboard";
    }
	@RequestMapping(value="/ninja/{id}/delete")
    public String delNinja(@PathVariable("id") Long id) {
        dnServ.deleteNinja(id);
        return "redirect:/dashboard";
    }
};
