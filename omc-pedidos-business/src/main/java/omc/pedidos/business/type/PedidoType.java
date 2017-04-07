/**
 * 
 */
package omc.pedidos.business.type;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 579535
 *
 */
public class PedidoType implements Serializable{
	
	private static final long serialVersionUID = 1056571401946603761L;

	private Long codigo;
	
	private String nome;
	
	private ProdutoType produtoType;
	
	private ClienteType clienteType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date dataCadastro;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
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
	 * @return the produtoType
	 */
	public ProdutoType getProdutoType() {
		return produtoType;
	}

	/**
	 * @param produtoType the produtoType to set
	 */
	public void setProdutoType(ProdutoType produtoType) {
		this.produtoType = produtoType;
	}

	/**
	 * @return the clienteType
	 */
	public ClienteType getClienteType() {
		return clienteType;
	}

	/**
	 * @param clienteType the clienteType to set
	 */
	public void setClienteType(ClienteType clienteType) {
		this.clienteType = clienteType;
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
