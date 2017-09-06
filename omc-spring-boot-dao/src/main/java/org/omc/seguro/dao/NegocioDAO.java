/**
 * 
 */
package org.omc.seguro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.omc.seguro.NegocioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ocean
 *
 */
@Transactional
@Repository
public class NegocioDAO  {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<NegocioEntity> getNegocios() {
		return this.sessionFactory.getCurrentSession().createQuery("SELECT n from NegocioEntity n ").list();
	}

	public NegocioEntity getNegocio() {
		return (NegocioEntity) this.sessionFactory.getCurrentSession().createQuery("SELECT n from NegocioEntity n ").uniqueResult();
		
	}
}
