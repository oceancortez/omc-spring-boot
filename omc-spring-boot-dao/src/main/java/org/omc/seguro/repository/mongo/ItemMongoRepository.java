package org.omc.seguro.repository.mongo;

import org.omc.seguro.mongo.domain.ItemDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemMongoRepository extends MongoRepository<ItemDomain, Long>{
	
	//@Query("{ 'cdItem' : ?0 }")
	ItemDomain findByCdItem(Long cdItem);

	
}
