/**
 * 
 */
package omc.pedidos.persistence;

import java.util.List;

import omc.pedidos.entity.ProductEntity;

/**
 * @author ocean
 *
 */
public interface IProductDAO extends IGenericDAO<ProductEntity, Long>  {	
	
	List<ProductEntity> listByName(String nome);

	List<ProductEntity> listProductsByCategoryId(Long categoryId);

}
