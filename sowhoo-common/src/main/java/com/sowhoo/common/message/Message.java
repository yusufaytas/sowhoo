package com.sowhoo.common.message;

import java.io.Serializable;

public class Message implements Serializable{

	private static final long serialVersionUID = -9019240831712679208L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
