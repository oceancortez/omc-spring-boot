package org.omc.seguro.to;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NegocioTO implements Serializable {

	private static final long serialVersionUID = -5075996221577731195L;

	private Integer cdNgoco;

	private String nmCia;

	private Integer cdRamo;

	private Integer cdApolice;

	private Integer cdApoliceSusep;

	private Integer cdMdupr;

	private String dsMdupr;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtEmissao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtInicoVigen;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtFimVigen;

	private String cdSitucNgoco;

	private Integer cdEstpl;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dtVigenPropor;

	private Integer cdGrpPrdut;

	private String dsGrpPrdut;

	private String cdPlaca;

	private String cdChassi;

	private Integer nrItseg;

	private Integer cdCorretor;

	private String nmCorretor;

	private Integer cdSucursal;

	private String nmSucursal;

	private String stNegocio;

	private Integer cdEndosso;

	private Integer cdClien;
	


	public Integer getCdNgoco() {
		return cdNgoco;
	}

	public void setCdNgoco(Integer cdNgoco) {
		this.cdNgoco = cdNgoco;
	}

	public String getNmCia() {
		return nmCia;
	}

	public void setNmCia(String nmCia) {
		this.nmCia = nmCia;
	}

	public Integer getCdRamo() {
		return cdRamo;
	}

	public void setCdRamo(Integer cdRamo) {
		this.cdRamo = cdRamo;
	}

	public Integer getCdApolice() {
		return cdApolice;
	}

	public void setCdApolice(Integer cdApolice) {
		this.cdApolice = cdApolice;
	}

	public Integer getCdApoliceSusep() {
		return cdApoliceSusep;
	}

	public void setCdApoliceSusep(Integer cdApoliceSusep) {
		this.cdApoliceSusep = cdApoliceSusep;
	}

	public Integer getCdMdupr() {
		return cdMdupr;
	}

	public void setCdMdupr(Integer cdMdupr) {
		this.cdMdupr = cdMdupr;
	}

	public String getDsMdupr() {
		return dsMdupr;
	}

	public void setDsMdupr(String dsMdupr) {
		this.dsMdupr = dsMdupr;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Date getDtInicoVigen() {
		return dtInicoVigen;
	}

	public void setDtInicoVigen(Date dtInicoVigen) {
		this.dtInicoVigen = dtInicoVigen;
	}

	public Date getDtFimVigen() {
		return dtFimVigen;
	}

	public void setDtFimVigen(Date dtFimVigen) {
		this.dtFimVigen = dtFimVigen;
	}

	public String getCdSitucNgoco() {
		return cdSitucNgoco;
	}

	public void setCdSitucNgoco(String cdSitucNgoco) {
		this.cdSitucNgoco = cdSitucNgoco;
	}

	public Integer getCdEstpl() {
		return cdEstpl;
	}

	public void setCdEstpl(Integer cdEstpl) {
		this.cdEstpl = cdEstpl;
	}

	public Date getDtVigenPropor() {
		return dtVigenPropor;
	}

	public void setDtVigenPropor(Date dtVigenPropor) {
		this.dtVigenPropor = dtVigenPropor;
	}

	public Integer getCdGrpPrdut() {
		return cdGrpPrdut;
	}

	public void setCdGrpPrdut(Integer cdGrpPrdut) {
		this.cdGrpPrdut = cdGrpPrdut;
	}

	public String getDsGrpPrdut() {
		return dsGrpPrdut;
	}

	public void setDsGrpPrdut(String dsGrpPrdut) {
		this.dsGrpPrdut = dsGrpPrdut;
	}

	public String getCdPlaca() {
		return cdPlaca;
	}

	public void setCdPlaca(String cdPlaca) {
		this.cdPlaca = cdPlaca;
	}

	public String getCdChassi() {
		return cdChassi;
	}

	public void setCdChassi(String cdChassi) {
		this.cdChassi = cdChassi;
	}

	public Integer getNrItseg() {
		return nrItseg;
	}

	public void setNrItseg(Integer nrItseg) {
		this.nrItseg = nrItseg;
	}

	public Integer getCdCorretor() {
		return cdCorretor;
	}

	public void setCdCorretor(Integer cdCorretor) {
		this.cdCorretor = cdCorretor;
	}

	public String getNmCorretor() {
		return nmCorretor;
	}

	public void setNmCorretor(String nmCorretor) {
		this.nmCorretor = nmCorretor;
	}

	public Integer getCdSucursal() {
		return cdSucursal;
	}

	public void setCdSucursal(Integer cdSucursal) {
		this.cdSucursal = cdSucursal;
	}

	public String getNmSucursal() {
		return nmSucursal;
	}

	public void setNmSucursal(String nmSucursal) {
		this.nmSucursal = nmSucursal;
	}

	public String getStNegocio() {
		return stNegocio;
	}

	public void setStNegocio(String stNegocio) {
		this.stNegocio = stNegocio;
	}

	public Integer getCdEndosso() {
		return cdEndosso;
	}

	public void setCdEndosso(Integer cdEndosso) {
		this.cdEndosso = cdEndosso;
	}

	public Integer getCdClien() {
		return cdClien;
	}

	public void setCdClien(Integer cdClien) {
		this.cdClien = cdClien;
	}
	
	

}
