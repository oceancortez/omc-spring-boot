package org.omc.rest;

import org.omc.seguro.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest")
public class NegocioREST {

	
	@Autowired NegocioService negocioService;
	
	@GetMapping(value = "getNegocio" )
	public @ResponseBody ResponseEntity<?> getNegocio(){
		
		return new ResponseEntity<>(negocioService.getNegocio(), HttpStatus.OK);
	}
	
	@GetMapping(value = "getNegocios" )
	public @ResponseBody ResponseEntity<?> getNegocios(){
		
		return new ResponseEntity<>(negocioService.getNegocios(), HttpStatus.OK);
	}
	
}
