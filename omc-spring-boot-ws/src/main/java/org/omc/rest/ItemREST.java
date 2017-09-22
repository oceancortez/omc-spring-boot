package org.omc.rest;

import javax.ws.rs.QueryParam;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.omc.seguro.excpetion.SeguroExcpetion;
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
@RequestMapping("api/rest/item")
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

		try {
			return new ResponseEntity<>(itemService.saveItem(to), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("updateItem")
	public ResponseEntity<?> updateItem(@RequestBody ItemTO to) {

		try {
			return new ResponseEntity<>(itemService.updateItem(to), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("deleteItem")
	public ResponseEntity<?> deleteItem(@QueryParam("cdItem") Long cdItem,
			@QueryParam("tpHistoItem") String tpHistoItem) {

		try {
			return new ResponseEntity<>(itemService.deleteItem(cdItem, tpHistoItem), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "getItemByIdForEachJava8")
	public ResponseEntity<?> getItemByIdForEachJava8(@RequestParam("id") Long id) {
		try {
			return new ResponseEntity<>(itemService.getItemByIdForEachJava8(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@PostMapping("saveItemWithCdNgoco")
	public ResponseEntity<?> saveItemWithCdNgoco(@RequestBody ItemTO to, @RequestParam("cdNgoco") Long cdNgoco, @RequestParam("tpHistoNgoco") String tpHistoNgoco) {

		try {
			
			return new ResponseEntity<>(itemService.saveItemWithCdNgoco(to, cdNgoco, tpHistoNgoco), HttpStatus.OK);
			
		} catch (SeguroExcpetion s) {
			return new ResponseEntity<>(s.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		} 		
		catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "getItensByCdNgoco")
	public ResponseEntity<?> getItensByCdNgoco(@RequestParam("cdNgoco") Long cdNgoco) {
		return new ResponseEntity<>(itemService.getItensByCdNgoco(cdNgoco), HttpStatus.OK);
	}
	
	@GetMapping(value = "getItemByCdItemMongo")
	public ResponseEntity<?> getItemByCdItemMongo(@RequestParam("cdItem") Long cdItem) {

		return new ResponseEntity<>(itemService.getItemByCdItemMongo(cdItem), HttpStatus.OK);
	}
	
	@GetMapping(value = "getItensByMongo")
	public ResponseEntity<?> getItensByMongo() {

		return new ResponseEntity<>(itemService.getItensByMongo(), HttpStatus.OK);
	}
	
	@PostMapping("saveItemMongo")
	public ResponseEntity<?> saveItemMongo(@RequestBody ItemTO to) {

		try {
			return new ResponseEntity<>(itemService.saveItemMongo(to), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(ExceptionUtils.getStackTrace(e), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
