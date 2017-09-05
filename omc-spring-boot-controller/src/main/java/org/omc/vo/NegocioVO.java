package org.omc.vo;

import java.io.Serializable;

import org.omc.seguro.to.NegocioTO;

public class NegocioVO implements Serializable {	
	
	private static final long serialVersionUID = -5075996221577731195L;
	
	private NegocioTO negocioTO;

	public NegocioTO getNegocioTO() {
		return negocioTO;
	}

	public void setNegocioTO(NegocioTO negocioTO) {
		this.negocioTO = negocioTO;
	}
	
	
	

}
