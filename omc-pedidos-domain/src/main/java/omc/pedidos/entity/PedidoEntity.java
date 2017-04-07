package omc.pedidos.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ocean
 *
 */

@Entity
@Table(name = "pedido", schema = "omc")
public class PedidoEntity {
	
	@Id
    @Column(name = "CODPED")
	private Long codigo;
	
	@Column(name = "NOMPED")
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CODCLI")
	private ClienteEntity clienteEntity;
	
	@OneToMany(mappedBy = "pedidoEntity" , cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProdutoEntity> produtoEntities;
	
	@Column(name = "DATCADPED")
	private Date dataCadastro;
	
	@Column(name = "DATULTALTPED")
	private Date dataUltimaAlteracao;

	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	

	/**
	 * @return the produtoEntities
	 */
	public List<ProdutoEntity> getProdutoEntities() {
		return produtoEntities;
	}

	/**
	 * @param produtoEntities the produtoEntities to set
	 */
	public void setProdutoEntities(List<ProdutoEntity> produtoEntities) {
		this.produtoEntities = produtoEntities;
	}

	/**
	 * @return the clienteEntity
	 */
	public ClienteEntity getClienteEntity() {
		return clienteEntity;
	}

	/**
	 * @param clienteEntity the clienteEntity to set
	 */
	public void setClienteEntity(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}


	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @return the dataUltimaAlteracao
	 */
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	/**
	 * @param dataUltimaAlteracao the dataUltimaAlteracao to set
	 */
	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}