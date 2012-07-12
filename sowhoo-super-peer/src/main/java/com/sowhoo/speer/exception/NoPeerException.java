package com.sowhoo.speer.exception;

public class NoPeerException extends Exception{

	private static final long serialVersionUID = 7240520441932461948L;

	public NoPeerException(){
		super();
	}
	
	public NoPeerException(String message){
		super(message);
	}
}
