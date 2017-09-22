package org.omc.rest;

import javax.ws.rs.QueryParam;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.omc.seguro.excpetion.SeguroExcpetion;
import org.omc.seguro.service.NegocioService;
import org.omc.seguro.to.NegocioTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest/negocio")
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
	
	@PostMapping("saveNegocio")
	public ResponseEntity<?> saveNegocio(@RequestBody NegocioTO to) {

		try {
			return new ResponseEntity<>(negocioService.saveNegocio(to), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("updateNegocio")
	public ResponseEntity<?> updateNegocio(@RequestBody NegocioTO to) {

		try {
			return new ResponseEntity<>(negocioService.updateNegocio(to), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("deleteNegocio")
	public ResponseEntity<?> deleteNegocio(@QueryParam("cdNgoco") Long cdNgoco,	@QueryParam("tpHistoNgoco") String tpHistoNgoco) {

		try {
			return new ResponseEntity<>(negocioService.deleteNegocio(cdNgoco, tpHistoNgoco), HttpStatus.OK);
			
		} catch (SeguroExcpetion s) {
			return new ResponseEntity<>(s.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
