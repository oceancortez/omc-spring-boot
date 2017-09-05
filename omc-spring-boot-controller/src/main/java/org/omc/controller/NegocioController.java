package org.omc.controller;

import org.omc.seguro.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("api/controller")
public class NegocioController {

	
	@Autowired NegocioService negocioService;
	
	@RequestMapping(value = "getNegocio", method = RequestMethod.GET)
	public ModelAndView  getNegocio(){
		
		return new ModelAndView("negocio").addObject("negocio", negocioService.getNegocio());
	}
	
	@RequestMapping(value = "getNegocios", method = RequestMethod.GET)
	public ModelAndView getNegocios(){
		
		return new ModelAndView("negocio").addObject("negocios", negocioService.getNegocios());
	}
	
}
