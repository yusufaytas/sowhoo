package com.sowhoo.common.message;

public class StringMessage extends Message<String,String>{

	private static final long serialVersionUID = 7574079837193685305L;
	
	public StringMessage(String header,String content){
		this.header = header;
		this.content = content;
	}
	
	public StringMessage(String content){
		this("",content);
	}

}
