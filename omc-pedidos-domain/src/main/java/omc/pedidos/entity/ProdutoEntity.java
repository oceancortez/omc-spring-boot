package omc.pedidos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "produto", schema = "omc")
public class ProdutoEntity implements Serializable{

	private static final long serialVersionUID = 6718909524788940370L;

	@Id
	@GeneratedValue
	@Column(name = "CODPRD")
	private Long codigo;
	
	@Column(name = "NOMPRD")
	private String nome;
	
	@Column(name = "VLRPRD")
	private Double valor;	
	
	@Column(name = "QTDPRD")
	private Integer quantidade;

	@Column(name = "DATCADPRD")
	private Date dataCadastro;
	
	@Column(name = "DATULTALTPRD")
	private Date dataUltimaAlteracao;
	
	/***
	 * <b>Um Produto pode ter muitos Pedidos<b>
	 */
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "produtoEntity")
	private List<PedidoEntity> pedidoEntities;

	public ProdutoEntity(String nomeProduto) {
		nome = nomeProduto;
	}

	public ProdutoEntity() {
		// TODO Auto-generated constructor stub
	}

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

	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
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
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return the pedidoEntities
	 */
	public List<PedidoEntity> getPedidoEntities() {
		return pedidoEntities;
	}

	/**
	 * @param pedidoEntities the pedidoEntities to set
	 */
	public void setPedidoEntities(List<PedidoEntity> pedidoEntities) {
		this.pedidoEntities = pedidoEntities;
	}	
}