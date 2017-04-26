/**
 * 
 */
package omc.pedidos.business.service;

import java.util.List;

import omc.pedidos.business.type.CategoryResponse;
import omc.pedidos.business.type.CategoryType;

/**
 * @author 579535
 *
 */
public interface ICategoryBusiness {

	List<CategoryType> listByName(String name);

	CategoryResponse create(String product);

	CategoryResponse listCategories();

	CategoryResponse update(String productJson);

	CategoryResponse delete(String productJson);

}
