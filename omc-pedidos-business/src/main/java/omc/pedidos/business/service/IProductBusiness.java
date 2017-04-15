/**
 * 
 */
package omc.pedidos.business.service;

import java.util.List;

import omc.pedidos.business.type.ProductType;

/**
 * @author 579535
 *
 */
public interface IProductBusiness {

	List<ProductType> listByName(String name);

	String createProduct(String product);

	List<ProductType> listProducts();

	String updateProduct(String productJson);

	String deleteProduct(String productJson);

}
