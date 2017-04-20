package omc.pedidos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ocean
 *
 */
@Entity
@Table(name = "category", schema = "omc")
public class CategoryEntity implements Serializable{

	private static final long serialVersionUID = -8442870016171976392L;

	@Id
	@GeneratedValue
	@Column(name = "CODCAT")
	private Long id;
	
	@Column(name = "NAMCAT")
	private String name;
	
	@Column(name = "DESCAT")
	private String description;	
	
	@Column(name = "PICCAT")
	private Byte[] picture;

	@Column(name = "DATCADCAT")
	private Date dateCreate;
	
	@Column(name = "DATULTALTCAT")
	private Date dateLastModification;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoryEntity")
	private Set<ProductEntity> productEntities;

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
	 * @return the productEntities
	 */
	public Set<ProductEntity> getProductEntities() {
		return productEntities;
	}

	/**
	 * @param productEntities the productEntities to set
	 */
	public void setProductEntities(Set<ProductEntity> productEntities) {
		this.productEntities = productEntities;
	}

		
}