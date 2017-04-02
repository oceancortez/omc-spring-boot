/**
 * 
 */
package omc.pedidos.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.TransactionRequiredException;
import javax.transaction.Transactional;

/**
 * @author 579535
 *
 */
@Transactional
public abstract class GenericDAO<T, PK>  implements IGenericDAO<T, PK>{

	@SuppressWarnings("rawtypes")
	private transient final Class entityClass;

	@SuppressWarnings("rawtypes")
	public GenericDAO() {
		entityClass = (Class) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@PersistenceContext
	private EntityManager manager;

	public T persist(final T entity) throws EntityExistsException, IllegalStateException, TransactionRequiredException,
			IllegalArgumentException {

		manager.persist(entity);
		manager.flush();
		return entity;

	}

	@SuppressWarnings("unchecked")
	public T findById(final PK primaryKey) throws IllegalStateException, IllegalArgumentException {
		return (T) manager.find(entityClass, primaryKey);
	}

	public void update(final T entity)
			throws IllegalStateException, IllegalArgumentException, TransactionRequiredException {
		manager.merge(entity);
		manager.flush();
	}

	public void delete(final T entity)
			throws IllegalStateException, IllegalArgumentException, TransactionRequiredException, PersistenceException {
		manager.remove(entity);
		manager.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.manager.createQuery("FROM " + this.getTypeClass().getName()).getResultList();
	}
	
	private Class<?> getTypeClass() {
		final Class<?> clazz =
				(Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return clazz;
	}
	
	@SuppressWarnings("rawtypes")
	public static Object getSingleResultOrNull(final Query query) {
		Object object;
		final List results = query.getResultList();
		if (results.isEmpty()) {
			object = null;
		} else if (results.size() == 1) {
			object = results.get(0);
		} else {
			throw new NonUniqueResultException();
		}
		return object;
	}

}
