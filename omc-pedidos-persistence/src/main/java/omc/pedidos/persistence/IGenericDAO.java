package omc.pedidos.persistence;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import javax.transaction.TransactionRequiredException;

public interface IGenericDAO<T, PK> {
	
	abstract T persist(final T entity) throws EntityExistsException, IllegalStateException, TransactionRequiredException,
	IllegalArgumentException;	
	
	abstract T findById(final PK primaryKey) throws IllegalStateException, IllegalArgumentException;

	abstract T update(final T entity) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException;

	abstract void delete(final T entity) throws IllegalStateException, IllegalArgumentException, TransactionRequiredException, PersistenceException;
	
	abstract List<T> findAll();

}
