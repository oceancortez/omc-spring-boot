package org.omc.seguro.service;

import java.util.ArrayList;
import java.util.List;

import org.omc.seguro.ItemEntity;
import org.omc.seguro.dao.ItemDAO;
import org.omc.seguro.parse.ParseUtil;
import org.omc.seguro.to.ItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired ItemDAO itemDAO;
	
	
	@SuppressWarnings("unchecked")
	public List<ItemTO> getItens() {
		return (List<ItemTO>) ParseUtil.parseEntitiesForTOs(itemDAO.getItens(), new ArrayList<ItemTO>());
	}


	public ItemTO getItemById(Long id) {		
		return ParseUtil.parseEntityForTO(itemDAO.findById(id, ItemEntity.class), ItemTO.class);
	}
	

}
