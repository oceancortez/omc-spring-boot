package org.omc.seguro.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class BaseDAO<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public T persist(final T transientInstance) {
		return (T) this.sessionFactory.getCurrentSession().save(transientInstance);
	}
	
	public void remove(final T persistentInstance) {
		this.sessionFactory.getCurrentSession().delete(persistentInstance);
	}
	
	@SuppressWarnings("unchecked")
	public T merge(final T detachedInstance) {
		return (T) this.sessionFactory.getCurrentSession().merge(detachedInstance);
	}
	
	@SuppressWarnings("unchecked")
	public T findById(final Long id, Class<?> persistClass) {
		return (T) this.sessionFactory.getCurrentSession().get(persistClass, id);
	}
}
