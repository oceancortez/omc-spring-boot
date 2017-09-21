package org.omc.seguro.service;

import java.util.ArrayList;
import java.util.List;

import org.omc.seguro.ItemEntity;
import org.omc.seguro.dao.BaseDAO;
import org.omc.seguro.dao.ItemDAO;
import org.omc.seguro.parse.ParseUtil;
import org.omc.seguro.repository.ItemRepository;
import org.omc.seguro.to.ItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends BaseDAO<ItemEntity>{
	
	@Autowired ItemDAO itemDAO;
	
	@Autowired ItemRepository itemRepository;
	
	
	@SuppressWarnings("unchecked")
	public List<ItemTO> getItens() {
		return (List<ItemTO>) ParseUtil.parseEntitiesForTOs(itemDAO.getItens(), new ArrayList<ItemTO>());
	}


	public ItemTO getItemById(Long id) {		
		return ParseUtil.parseObjectAForB(itemDAO.findById(id, ItemEntity.class), ItemTO.class);
	}


	public ItemTO saveItem(ItemTO to) {
		ItemTO itemTO = null;		
		try {
			ItemEntity entity = ParseUtil.parseObjectAForB(to, ItemEntity.class);
			entity = itemDAO.merge(entity);
			itemTO = ParseUtil.parseObjectAForB(entity, ItemTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemTO;
	}


	public ItemTO updateItem(ItemTO to) {
		ItemTO itemTO = null;		
		try {
			ItemEntity entity = ParseUtil.parseObjectAForB(to, ItemEntity.class);
			entity = itemRepository.saveAndFlush(entity);
			itemTO = ParseUtil.parseObjectAForB(entity, ItemTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemTO;
	}


	public String deleteItem(Long cdItem, String tpHistoItem) throws Exception {
		try {			
			ItemEntity item = itemRepository.findByCdItemAndTpHistoItem(cdItem, tpHistoItem);
			itemRepository.delete(item);
		} catch (Exception e) {
			throw new Exception(e);
		}		
		return "sucesso";
		
	}


	public ItemTO getItemByIdForEachJava8(Long id) throws Exception {
			
		try {
			
			List<ItemEntity> itens = itemRepository.findAll();
			final ItemTO itemTO = new ItemTO();
			
			itens.forEach(item -> {
				
				if(id == item.getCdItem()) {
					itemTO.setCdItem(item.getCdItem());
					itemTO.setCdApoli(item.getCdApoli());
					itemTO.setCdApoliSusepRenov(item.getCdApoliSusepRenov());
					itemTO.setCdClien(item.getCdClien());
					itemTO.setCdEndos(item.getCdEndos());
					itemTO.setCdMdupr(item.getCdMdupr());
					itemTO.setCdNgoco(item.getCdNgoco());
					itemTO.setDtEmissItem(item.getDtEmissItem());
					itemTO.setDtUltmaAlter(item.getDtUltmaAlter());
					itemTO.setTpHistoItem(item.getTpHistoItem());
					itemTO.setTpHistoNgoco(item.getTpHistoNgoco());
				}
				
			 return;
				
			});
			
			return itemTO;
			
		} catch (Exception e) {
			throw new Exception(e);
		}
		
	}
	

}
