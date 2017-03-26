/**
 * 
 */
package omc.pedidos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ocean
 *
 */
@Entity
@Table(name = "cliente", schema = "omc")
public class ClienteEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "CODCLI")
	private Long codigo;
	
	@Column(name = "NOMCLI")
	private String nome;
	
	@Column(name = "DATCADCLI")
	private Date dataCadastro;
	
	@Column(name = "DATULTALTCLI")
	private Date dataUltimaAlteracao;
	
	
	public ClienteEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteEntity(Long codigoCliente) {
		codigo = codigoCliente;
	}
	
	
	
	public ClienteEntity(String nome, Date dataCadastro, Date dataUltimaAlteracao) {
		super();
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
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


}
