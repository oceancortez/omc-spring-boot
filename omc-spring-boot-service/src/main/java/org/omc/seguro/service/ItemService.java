package org.omc.seguro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.omc.seguro.ItemEntity;
import org.omc.seguro.NegocioEntity;
import org.omc.seguro.dao.BaseDAO;
import org.omc.seguro.dao.ItemDAO;
import org.omc.seguro.excpetion.SeguroExcpetion;
import org.omc.seguro.mongo.domain.ItemDomain;
import org.omc.seguro.parse.ParseUtil;
import org.omc.seguro.repository.data.ItemRepository;
import org.omc.seguro.repository.data.NegocioRepository;
import org.omc.seguro.repository.mongo.ItemMongoRepository;
import org.omc.seguro.to.ItemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends BaseDAO<ItemEntity> {

	@Autowired	ItemDAO itemDAO;

	@Autowired	ItemRepository itemRepository;

	@Autowired	NegocioRepository negocioRepository;
	
	@Autowired ItemMongoRepository itemMongoRepository;
		

	@SuppressWarnings("unchecked")
	public List<ItemTO> getItens() {
		return (List<ItemTO>) ParseUtil.parseEntitiesForTOs(itemDAO.getItens(), new ArrayList<ItemTO>());
	}

	public ItemTO getItemById(Long id) {
		return ParseUtil.parseObjectAForB(itemDAO.findById(id, ItemEntity.class), ItemTO.class);
	}

	public ItemTO saveItem(ItemTO to) throws Exception {
		ItemTO itemTO = null;
		try {
			ItemEntity entity = ParseUtil.parseObjectAForB(to, ItemEntity.class);
			entity.setDtUltmaAlter(entity.getDtUltmaAlter() == null ? new Date() : entity.getDtUltmaAlter());
			entity = itemDAO.merge(entity);
			itemTO = ParseUtil.parseObjectAForB(entity, ItemTO.class);
		} catch (Exception e) {
			throw new Exception(e);
		}
		return itemTO;
	}

	public ItemTO updateItem(ItemTO to) throws Exception {
		ItemTO itemTO = null;
		try {
			ItemEntity entity = ParseUtil.parseObjectAForB(to, ItemEntity.class);
			entity.setDtUltmaAlter(entity.getDtUltmaAlter() == null ? new Date() : entity.getDtUltmaAlter());
			entity = itemRepository.saveAndFlush(entity);
			itemTO = ParseUtil.parseObjectAForB(entity, ItemTO.class);
		} catch (Exception e) {
			throw new Exception(e);
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

				if (id == item.getCdItem()) {
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

	public ItemTO saveItemWithCdNgoco(ItemTO to, Long cdNgoco, String tpHistoNgoco) throws Exception {
		ItemTO itemTO;
		try {

			Optional<NegocioEntity> negocioEntity = negocioRepository.findByCdNgocoAndTpHistoNgoco(cdNgoco,	tpHistoNgoco);

			if (!negocioEntity.isPresent()) {
				throw new SeguroExcpetion("Negocio não existente! Favor cadastrar um negocio com o cdNgoco="+cdNgoco);
			}

			ItemEntity entity = ParseUtil.parseObjectAForB(to, ItemEntity.class);
			entity.setDtUltmaAlter(entity.getDtUltmaAlter() == null ? new Date() : entity.getDtUltmaAlter());
			entity.setCdNgoco(negocioEntity.get().getCdNgoco());
			entity = itemDAO.merge(entity);
			itemTO = ParseUtil.parseObjectAForB(entity, ItemTO.class);

		} catch (Exception e) {
			throw new Exception(e);
		}

		return itemTO;
	}
	
	@SuppressWarnings("unchecked")
	public List<ItemTO> getItensByCdNgoco(Long cdNgoco) {
		return (List<ItemTO>)  ParseUtil.parseEntitiesForTOs(itemRepository.findByCdNgoco(cdNgoco), new ArrayList<ItemTO>());
	}
	
	public ItemTO getItemByCdItemMongo(Long cdItem) {
		return ParseUtil.parseObjectAForB(itemMongoRepository.findByCdItem(cdItem), ItemTO.class);
	}

	@SuppressWarnings("unchecked")
	public List<ItemTO> getItensByMongo() {
		return (List<ItemTO>) ParseUtil.parseEntitiesForTOs(itemMongoRepository.findAll(), new ArrayList<ItemTO>());
	}

	public ItemTO saveItemMongo(ItemTO to) {		
		
		ItemDomain item = itemMongoRepository.save(
								new ItemDomain(
												to.getCdItem(),
												to.getTpHistoItem(),
												to.getCdApoli(),
												to.getCdApoliSusepRenov(),
												to.getCdClien(),
												to.getCdEndos(),
												to.getCdNgoco(),
												to.getTpHistoNgoco(),
												to.getCdMdupr(),
												to.getDtUltmaAlter(),
												to.getDtEmissItem())
								);
		return ParseUtil.parseObjectAForB(item, ItemTO.class);
	}

}
