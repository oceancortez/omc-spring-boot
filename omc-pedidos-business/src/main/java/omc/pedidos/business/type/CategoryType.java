package omc.pedidos.business.type;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import omc.pedidos.entity.ProductEntity;

public class CategoryType implements Serializable{

	private static final long serialVersionUID = -2097014875432029954L;

	private Long id;

	private String name;
	
	private String description;	
	
	private Byte[] picture;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dateCreate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dateLastModification;
	
	private Set<ProductType> productTypes;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the picture
	 */
	public Byte[] getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(Byte[] picture) {
		this.picture = picture;
	}

	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {
		return dateCreate;
	}

	/**
	 * @param dateCreate the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	/**
	 * @return the dateLastModification
	 */
	public Date getDateLastModification() {
		return dateLastModification;
	}

	/**
	 * @param dateLastModification the dateLastModification to set
	 */
	public void setDateLastModification(Date dateLastModification) {
		this.dateLastModification = dateLastModification;
	}

	/**
	 * @return the productTypes
	 */
	public Set<ProductType> getProductTypes() {
		return productTypes;
	}

	/**
	 * @param productTypes the productTypes to set
	 */
	public void setProductTypes(Set<ProductType> productTypes) {
		this.productTypes = productTypes;
	}


}
