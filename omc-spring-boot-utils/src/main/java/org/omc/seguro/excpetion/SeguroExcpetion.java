package org.omc.seguro.excpetion;

public class SeguroExcpetion extends Exception {

	private static final long serialVersionUID = 662375085059487852L;
	
	private String message;
	
	public SeguroExcpetion() {
		super();
	}
	
	public SeguroExcpetion(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
