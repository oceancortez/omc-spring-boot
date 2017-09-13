package org.omc.seguro.service;

import java.util.ArrayList;
import java.util.List;

import org.omc.seguro.ItemEntity;
import org.omc.seguro.dao.BaseDAO;
import org.omc.seguro.dao.ItemDAO;
import org.omc.seguro.parse.ParseUtil;
import org.omc.seguro.to.ItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends BaseDAO<ItemEntity>{
	
	@Autowired ItemDAO itemDAO;
	
	
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
	

}
