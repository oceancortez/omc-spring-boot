/**
 * 
 */
package org.omc.seguro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.omc.seguro.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ocean
 *
 */
@Transactional
@Repository
public class ItemDAO  extends BaseDAO<ItemEntity> {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<ItemEntity> getItens() {
		return this.sessionFactory.getCurrentSession().createQuery("SELECT i from ItemEntity i ").list();
	}
}
