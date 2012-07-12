package com.sowhoo.speer.exception;

public class UnAuthorizedPeerException extends Exception{

	private static final long serialVersionUID = -825854619329673697L;

	public UnAuthorizedPeerException(){
		super();
	}
	
	public UnAuthorizedPeerException(String message){
		super(message);
	}
}
