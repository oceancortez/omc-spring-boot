package org.omc.seguro.to;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemTO implements Serializable{

	private static final long serialVersionUID = 1090369397667800507L;

	private Long cdItem;
	
	private String tpHistoItem;

	private Long cdApoli;

	private Long cdApoliSusepRenov;

	private Long cdClien;

	private Long cdEndos;

	private Long cdNgoco;

	private Long cdMdupr;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	private Date dtUltmaAlter;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dtEmissItem;
	
	private String tpHistoNgoco;	


	public ItemTO(Long cdItem, String tpHistoItem, Long cdApoli, Long cdApoliSusepRenov, Long cdClien, Long cdEndos,
			Long cdNgoco, Long cdMdupr, Date dtUltmaAlter, Date dtEmissItem, String tpHistoNgoco) {
		super();
		this.cdItem = cdItem;
		this.tpHistoItem = tpHistoItem;
		this.cdApoli = cdApoli;
		this.cdApoliSusepRenov = cdApoliSusepRenov;
		this.cdClien = cdClien;
		this.cdEndos = cdEndos;
		this.cdNgoco = cdNgoco;
		this.cdMdupr = cdMdupr;
		this.dtUltmaAlter = dtUltmaAlter;
		this.dtEmissItem = dtEmissItem;
		this.tpHistoNgoco = tpHistoNgoco;
	}

	public ItemTO() {
		
	}

	public Long getCdItem() {
		return cdItem;
	}

	public void setCdItem(Long cdItem) {
		this.cdItem = cdItem;
	}

	public Long getCdApoli() {
		return cdApoli;
	}

	public void setCdApoli(Long cdApoli) {
		this.cdApoli = cdApoli;
	}

	public Long getCdApoliSusepRenov() {
		return cdApoliSusepRenov;
	}

	public void setCdApoliSusepRenov(Long cdApoliSusepRenov) {
		this.cdApoliSusepRenov = cdApoliSusepRenov;
	}

	public Long getCdClien() {
		return cdClien;
	}

	public void setCdClien(Long cdClien) {
		this.cdClien = cdClien;
	}

	public Long getCdEndos() {
		return cdEndos;
	}

	public void setCdEndos(Long cdEndos) {
		this.cdEndos = cdEndos;
	}

	public Long getCdNgoco() {
		return cdNgoco;
	}

	public void setCdNgoco(Long cdNgoco) {
		this.cdNgoco = cdNgoco;
	}

	public Long getCdMdupr() {
		return cdMdupr;
	}

	public void setCdMdupr(Long cdMdupr) {
		this.cdMdupr = cdMdupr;
	}

	public Date getDtUltmaAlter() {
		return dtUltmaAlter;
	}

	public void setDtUltmaAlter(Date dtUltmaAlter) {
		this.dtUltmaAlter = dtUltmaAlter;
	}

	public Date getDtEmissItem() {
		return dtEmissItem;
	}

	public void setDtEmissItem(Date dtEmissItem) {
		this.dtEmissItem = dtEmissItem;
	}

	public String getTpHistoItem() {
		return tpHistoItem;
	}

	public void setTpHistoItem(String tpHistoItem) {
		this.tpHistoItem = tpHistoItem;
	}

	public String getTpHistoNgoco() {
		return tpHistoNgoco;
	}

	public void setTpHistoNgoco(String tpHistoNgoco) {
		this.tpHistoNgoco = tpHistoNgoco;
	}
	
	

}
