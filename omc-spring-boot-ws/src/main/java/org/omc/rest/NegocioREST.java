package org.omc.rest;

import org.omc.seguro.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest")
public class NegocioREST {

	
	@Autowired NegocioService negocioService;
	
	@GetMapping(value = "getNegocioById" )
	public ResponseEntity<?> getNegocioById(@RequestParam("id") Long id){		
		return new ResponseEntity<>(negocioService.getNegocioById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "getNegocios" )
	public ResponseEntity<?> getNegocios(){
		
		return new ResponseEntity<>(negocioService.getNegocios(), HttpStatus.OK);
	}
	
}
