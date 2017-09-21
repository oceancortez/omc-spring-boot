package org.omc.rest;

import javax.ws.rs.QueryParam;

import org.omc.seguro.service.ItemService;
import org.omc.seguro.to.ItemTO;
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
@RequestMapping("api/rest")
public class ItemREST {

	@Autowired
	ItemService itemService;

	@GetMapping(value = "getItemById")
	public ResponseEntity<?> getItemById(@RequestParam("id") Long id) {
		return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
	}

	@GetMapping(value = "getItens")
	public ResponseEntity<?> getItens() {

		return new ResponseEntity<>(itemService.getItens(), HttpStatus.OK);
	}

	@PostMapping("saveItem")
	public ResponseEntity<?> saveItem(@RequestBody ItemTO to) {

		return new ResponseEntity<>(itemService.saveItem(to), HttpStatus.OK);
	}

	@PutMapping("updateItem")
	public ResponseEntity<ItemTO> updateItem(@RequestBody ItemTO to) {

		return new ResponseEntity<>(itemService.updateItem(to), HttpStatus.OK);
	}

	@DeleteMapping("deleteItem")
	public ResponseEntity<?> deleteItem(@QueryParam("cdItem") Long cdItem,
			@QueryParam("tpHistoItem") String tpHistoItem) {

		try {
			return new ResponseEntity<>(itemService.deleteItem(cdItem, tpHistoItem), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "getItemByIdForEachJava8")
	public ResponseEntity<?> getItemByIdForEachJava8(@RequestParam("id") Long id) {
		try {
			return new ResponseEntity<>(itemService.getItemByIdForEachJava8(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

}
