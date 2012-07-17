package com.sowhoo.common.message;

public class StringMessageContent extends MessageContent<String>{

	public StringMessageContent(){
		this("");
	}
	
	public StringMessageContent(String content){
		this.content = content;
	}
}
