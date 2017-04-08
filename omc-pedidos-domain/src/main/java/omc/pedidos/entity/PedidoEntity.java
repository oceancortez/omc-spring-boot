package omc.pedidos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author ocean
 *
 */

@Entity
@Table(name = "pedido", schema = "omc")
public class PedidoEntity implements Serializable{
	

	private static final long serialVersionUID = 6428635798565412036L;

	/***
	 * <b>Sobrescrevendo o atributo java pelo nome da tabela<b>
	 */
	@AttributeOverrides({
		@AttributeOverride(name = "codigoPedido", column = @Column(name = "CODPED", nullable = false)),
		@AttributeOverride(name = "codigoProduto", column = @Column(name = "CODPRD", nullable = false)) })
	@EmbeddedId
	private PedidoEntityPK id;
	
	@Column(name = "NOMPED")
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CODCLI")
	private ClienteEntity clienteEntity;
	
	/***
	 * <b>Muitos pedidos podem ter um produto<b>
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "CODPRD", nullable = false, insertable = false, updatable = false)
	private ProdutoEntity produtoEntity;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "DATCADPED")
	private Date dataCadastro;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name = "DATULTALTPED")
	private Date dataUltimaAlteracao;
		
	/**
	 * @return the id
	 */
	public PedidoEntityPK getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(PedidoEntityPK id) {
		this.id = id;
	}

	/**
	 * @return the produtoEntity
	 */
	public ProdutoEntity getProdutoEntity() {
		return produtoEntity;
	}

	/**
	 * @param produtoEntity the produtoEntity to set
	 */
	public void setProdutoEntity(ProdutoEntity produtoEntity) {
		this.produtoEntity = produtoEntity;
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