package org.omc.seguro.repository;

import org.omc.seguro.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

	ItemEntity findByCdItemAndTpHistoItem(Long cdItem, String tpHistoItem);

}
