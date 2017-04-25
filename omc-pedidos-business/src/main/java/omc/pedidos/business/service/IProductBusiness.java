/**
 * 
 */
package omc.pedidos.business.service;

import java.util.List;

import omc.pedidos.business.type.ProductResponse;
import omc.pedidos.business.type.ProductType;

/**
 * @author 579535
 *
 */
public interface IProductBusiness {

	List<ProductType> listByName(String name);

	ProductResponse createProduct(String product);

	ProductResponse listProducts();

	ProductResponse updateProduct(String productJson);

	String deleteProduct(String productJson);

	ProductResponse listProductsByCategoryId(final Long categoryId);

}
