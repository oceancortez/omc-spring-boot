/**
 * 
 */
package omc.pedidos.business.type;

import java.io.Serializable;
import java.util.List;

/**
 * @author 579535
 *
 */
public class ProductResponse implements Serializable{
	
	private static final long serialVersionUID = -6833522821598664236L;	
	
	private ProductType productType;
	
	private List<ProductType> productTypes;

	private String message;
	
	public ProductResponse(List<ProductType> parseTypes) {
		this.productTypes = parseTypes;
	}
	
	public ProductResponse(String message) {
		this.message = message;
	}

	public ProductResponse() {
		
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the productTypes
	 */
	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	/**
	 * @param productTypes the productTypes to set
	 */
	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}


}
