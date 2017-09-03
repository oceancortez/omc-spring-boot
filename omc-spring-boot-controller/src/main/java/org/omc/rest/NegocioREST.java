package org.omc.rest;

import org.omc.vo.NegocioVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class NegocioREST {

	
	@RequestMapping(value = "getNegocio", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getNegocio(){
		
		return new ResponseEntity<NegocioVO>(new NegocioVO(), HttpStatus.OK);
	}
	
}
