package org.omc.seguro.repository.test;

import org.junit.Test;
import org.omc.seguro.ItemEntity;
import org.omc.seguro.repository.ItemRepository;
import org.omc.seguro.test.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ItemRepositoryTest extends BaseTest {
	
	@Autowired ItemRepository itemRepository;
	
	@Test
	public void getItemById() {
		ItemEntity entity = itemRepository.findOne(1);
		Assert.assertNotNull(entity);
	}

}
