package org.omc.rest;

import org.omc.seguro.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest")
public class NegocioREST {

	
	@Autowired NegocioService negocioService;
	
	@RequestMapping(value = "getNegocio", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getNegocio(){
		
		return new ResponseEntity<>(negocioService.getNegocio(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "getNegocios", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getNegocios(){
		
		return new ResponseEntity<>(negocioService.getNegocios(), HttpStatus.OK);
	}
	
}
