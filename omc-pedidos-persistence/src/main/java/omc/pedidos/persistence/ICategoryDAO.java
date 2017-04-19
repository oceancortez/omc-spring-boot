/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import omc.pedidos.entity.CategoryEntity;

/**
 * @author ocean
 *
 */
public interface ICategoryDAO extends IGenericDAO<CategoryEntity, Long>  {	
	
	List<CategoryEntity> listByName(String nome);

}
