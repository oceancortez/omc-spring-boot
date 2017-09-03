package org.omc.vo;

import java.io.Serializable;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NegocioVO implements Serializable {	
	
	private static final long serialVersionUID = -5075996221577731195L;
	
	private String nmCia;
	private Long cdRamo;
	private Long cdApolice;
	private Long cdApoliceSusep;
	private Long cdMdupr;	
	private String dsMdupr;
	private Long cdNgoco;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtEmissao;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtInicoVigen;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtFimVigen;
	private String cdSitucNgoco;
	private Long cdEstpl;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtVigenProporcional;
	private Long cdGrpPrdut;
	private String cdPlaca;
	private String cdChassi;
	private Long nrItseg;	
	private Long cdCorretor;
	private String nmCorretor;
	private Long cdSucursal;
	private String nmSucursal;
	private String stNegocio;	
	private Long cdEndosso;
	private String dsGrpPrdut;
	private Long cdClien;
	/**
	 * @return the nmCia
	 */
	public String getNmCia() {
		return nmCia;
	}
	/**
	 * @param nmCia the nmCia to set
	 */
	public void setNmCia(String nmCia) {
		this.nmCia = nmCia;
	}
	/**
	 * @return the cdRamo
	 */
	public Long getCdRamo() {
		return cdRamo;
	}
	/**
	 * @param cdRamo the cdRamo to set
	 */
	public void setCdRamo(Long cdRamo) {
		this.cdRamo = cdRamo;
	}
	/**
	 * @return the cdApolice
	 */
	public Long getCdApolice() {
		return cdApolice;
	}
	/**
	 * @param cdApolice the cdApolice to set
	 */
	public void setCdApolice(Long cdApolice) {
		this.cdApolice = cdApolice;
	}
	/**
	 * @return the cdApoliceSusep
	 */
	public Long getCdApoliceSusep() {
		return cdApoliceSusep;
	}
	/**
	 * @param cdApoliceSusep the cdApoliceSusep to set
	 */
	public void setCdApoliceSusep(Long cdApoliceSusep) {
		this.cdApoliceSusep = cdApoliceSusep;
	}
	/**
	 * @return the cdMdupr
	 */
	public Long getCdMdupr() {
		return cdMdupr;
	}
	/**
	 * @param cdMdupr the cdMdupr to set
	 */
	public void setCdMdupr(Long cdMdupr) {
		this.cdMdupr = cdMdupr;
	}
	/**
	 * @return the dsMdupr
	 */
	public String getDsMdupr() {
		return dsMdupr;
	}
	/**
	 * @param dsMdupr the dsMdupr to set
	 */
	public void setDsMdupr(String dsMdupr) {
		this.dsMdupr = dsMdupr;
	}
	/**
	 * @return the cdNgoco
	 */
	public Long getCdNgoco() {
		return cdNgoco;
	}
	/**
	 * @param cdNgoco the cdNgoco to set
	 */
	public void setCdNgoco(Long cdNgoco) {
		this.cdNgoco = cdNgoco;
	}
	/**
	 * @return the dtEmissao
	 */
	public Date getDtEmissao() {
		return dtEmissao;
	}
	/**
	 * @param dtEmissao the dtEmissao to set
	 */
	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}
	/**
	 * @return the dtInicoVigen
	 */
	public Date getDtInicoVigen() {
		return dtInicoVigen;
	}
	/**
	 * @param dtInicoVigen the dtInicoVigen to set
	 */
	public void setDtInicoVigen(Date dtInicoVigen) {
		this.dtInicoVigen = dtInicoVigen;
	}
	/**
	 * @return the dtFimVigen
	 */
	public Date getDtFimVigen() {
		return dtFimVigen;
	}
	/**
	 * @param dtFimVigen the dtFimVigen to set
	 */
	public void setDtFimVigen(Date dtFimVigen) {
		this.dtFimVigen = dtFimVigen;
	}
	/**
	 * @return the cdSitucNgoco
	 */
	public String getCdSitucNgoco() {
		return cdSitucNgoco;
	}
	/**
	 * @param cdSitucNgoco the cdSitucNgoco to set
	 */
	public void setCdSitucNgoco(String cdSitucNgoco) {
		this.cdSitucNgoco = cdSitucNgoco;
	}
	/**
	 * @return the cdEstpl
	 */
	public Long getCdEstpl() {
		return cdEstpl;
	}
	/**
	 * @param cdEstpl the cdEstpl to set
	 */
	public void setCdEstpl(Long cdEstpl) {
		this.cdEstpl = cdEstpl;
	}
	/**
	 * @return the dtVigenProporcional
	 */
	public Date getDtVigenProporcional() {
		return dtVigenProporcional;
	}
	/**
	 * @param dtVigenProporcional the dtVigenProporcional to set
	 */
	public void setDtVigenProporcional(Date dtVigenProporcional) {
		this.dtVigenProporcional = dtVigenProporcional;
	}
	/**
	 * @return the cdGrpPrdut
	 */
	public Long getCdGrpPrdut() {
		return cdGrpPrdut;
	}
	/**
	 * @param cdGrpPrdut the cdGrpPrdut to set
	 */
	public void setCdGrpPrdut(Long cdGrpPrdut) {
		this.cdGrpPrdut = cdGrpPrdut;
	}
	/**
	 * @return the cdPlaca
	 */
	public String getCdPlaca() {
		return cdPlaca;
	}
	/**
	 * @param cdPlaca the cdPlaca to set
	 */
	public void setCdPlaca(String cdPlaca) {
		this.cdPlaca = cdPlaca;
	}
	/**
	 * @return the cdChassi
	 */
	public String getCdChassi() {
		return cdChassi;
	}
	/**
	 * @param cdChassi the cdChassi to set
	 */
	public void setCdChassi(String cdChassi) {
		this.cdChassi = cdChassi;
	}
	/**
	 * @return the nrItseg
	 */
	public Long getNrItseg() {
		return nrItseg;
	}
	/**
	 * @param nrItseg the nrItseg to set
	 */
	public void setNrItseg(Long nrItseg) {
		this.nrItseg = nrItseg;
	}
	/**
	 * @return the cdCorretor
	 */
	public Long getCdCorretor() {
		return cdCorretor;
	}
	/**
	 * @param cdCorretor the cdCorretor to set
	 */
	public void setCdCorretor(Long cdCorretor) {
		this.cdCorretor = cdCorretor;
	}
	/**
	 * @return the nmCorretor
	 */
	public String getNmCorretor() {
		return nmCorretor;
	}
	/**
	 * @param nmCorretor the nmCorretor to set
	 */
	public void setNmCorretor(String nmCorretor) {
		this.nmCorretor = nmCorretor;
	}
	/**
	 * @return the cdSucursal
	 */
	public Long getCdSucursal() {
		return cdSucursal;
	}
	/**
	 * @param cdSucursal the cdSucursal to set
	 */
	public void setCdSucursal(Long cdSucursal) {
		this.cdSucursal = cdSucursal;
	}
	/**
	 * @return the nmSucursal
	 */
	public String getNmSucursal() {
		return nmSucursal;
	}
	/**
	 * @param nmSucursal the nmSucursal to set
	 */
	public void setNmSucursal(String nmSucursal) {
		this.nmSucursal = nmSucursal;
	}
	/**
	 * @return the stNegocio
	 */
	public String getStNegocio() {
		return stNegocio;
	}
	/**
	 * @param stNegocio the stNegocio to set
	 */
	public void setStNegocio(String stNegocio) {
		this.stNegocio = stNegocio;
	}
	/**
	 * @return the cdEndosso
	 */
	public Long getCdEndosso() {
		return cdEndosso;
	}
	/**
	 * @param cdEndosso the cdEndosso to set
	 */
	public void setCdEndosso(Long cdEndosso) {
		this.cdEndosso = cdEndosso;
	}
	/**
	 * @return the dsGrpPrdut
	 */
	public String getDsGrpPrdut() {
		return dsGrpPrdut;
	}
	/**
	 * @param dsGrpPrdut the dsGrpPrdut to set
	 */
	public void setDsGrpPrdut(String dsGrpPrdut) {
		this.dsGrpPrdut = dsGrpPrdut;
	}
	/**
	 * @return the cdClien
	 */
	public Long getCdClien() {
		return cdClien;
	}
	/**
	 * @param cdClien the cdClien to set
	 */
	public void setCdClien(Long cdClien) {
		this.cdClien = cdClien;
	}
	
	
	
	

}
