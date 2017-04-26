/**
 * 
 */
package omc.pedidos.business.type;

import java.util.List;

/**
 * @author 579535
 *
 */
public class CategoryResponse {
	
	private CategoryType categoryType;
	
	private List<CategoryType> categoryTypes;
	
	private String message;
	
	/**
	 * @return the categoryType
	 */
	public CategoryType getCategoryType() {
		return categoryType;
	}

	/**
	 * @param categoryType the categoryType to set
	 */
	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	/**
	 * @return the categoryTypes
	 */
	public List<CategoryType> getCategoryTypes() {
		return categoryTypes;
	}

	/**
	 * @param categoryTypes the categoryTypes to set
	 */
	public void setCategoryTypes(List<CategoryType> categoryTypes) {
		this.categoryTypes = categoryTypes;
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



}
