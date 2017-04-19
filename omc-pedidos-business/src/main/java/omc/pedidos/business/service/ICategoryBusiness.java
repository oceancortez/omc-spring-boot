/**
 * 
 */
package omc.pedidos.business.service;

import java.util.List;

import omc.pedidos.business.type.CategoryType;

/**
 * @author 579535
 *
 */
public interface ICategoryBusiness {

	List<CategoryType> listByName(String name);

	String create(String product);

	List<CategoryType> listCategories();

	String update(String productJson);

	String delete(String productJson);

}
