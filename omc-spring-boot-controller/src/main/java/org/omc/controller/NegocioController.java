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
	
	@RequestMapping(value = "getNegocioJdbcTemplate", method = RequestMethod.GET)
	public ModelAndView  getNegocioJdbcTemplate(){
		
		return new ModelAndView("negocio").addObject("negocio", negocioService.getNegocioJdbcTemplate());
	}
	
	@RequestMapping(value = "getNegociosJdbcTemplate", method = RequestMethod.GET)
	public ModelAndView getNegociosJdbcTemplate(){
		
		return new ModelAndView("negocio").addObject("negocios", negocioService.getNegociosJdbcTemplate());
	}
	
	@RequestMapping(value = "getNegocioSpringDataJPA", method = RequestMethod.GET)
	public ModelAndView  getNegocioSpringDataJPA(){
		
		return new ModelAndView("negocio").addObject("negocio", negocioService.getNegocioSpringDataJPA());
	}
	
	@RequestMapping(value = "getNegociosSpringDataJPA", method = RequestMethod.GET)
	public ModelAndView getNegociosSpringDataJPA(){
		
		return new ModelAndView("negocio").addObject("negocios", negocioService.getNegociosSpringDataJPA());
	}
	
}
