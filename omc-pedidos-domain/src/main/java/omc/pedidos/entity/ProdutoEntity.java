package omc.pedidos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author ocean
 *
 */
@Entity
@Table(name = "produto", schema = "omc")
public class ProdutoEntity {
	
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
	
	@ManyToOne
	//@JoinColumn(name = "CODPED", insertable=false, updatable=false)
	private PedidoEntity pedidoEntity;

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
	 * @return the pedidoEntity
	 */
	public PedidoEntity getPedidoEntity() {
		return pedidoEntity;
	}

	/**
	 * @param pedidoEntity the pedidoEntity to set
	 */
	public void setPedidoEntity(PedidoEntity pedidoEntity) {
		this.pedidoEntity = pedidoEntity;
	}

}