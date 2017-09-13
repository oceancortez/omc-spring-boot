package org.omc.rest;

import org.omc.seguro.service.ItemService;
import org.omc.seguro.to.ItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rest")
public class ItemREST {

	@Autowired
	ItemService itemService;

	 @GetMapping(value = "getItemById" )
	 public ResponseEntity<?> getItemById(@RequestParam("id") Long id){
	 return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
	 }

	@GetMapping(value = "getItens")
	public ResponseEntity<?> getItens() {

		return new ResponseEntity<>(itemService.getItens(), HttpStatus.OK);
	}
	
	@PostMapping("saveItem")
	public ResponseEntity<?> saveItem(@RequestBody ItemTO to){
			
		return new ResponseEntity<>(itemService.saveItem(to), HttpStatus.OK);
	}

}
