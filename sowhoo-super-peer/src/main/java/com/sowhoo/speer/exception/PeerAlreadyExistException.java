package com.sowhoo.speer.exception;

public class PeerAlreadyExistException extends Exception{

	private static final long serialVersionUID = 3198784535050328757L;

	public PeerAlreadyExistException(){
		super();
	}
	
	public PeerAlreadyExistException(String message){
		super(message);
	}
}
