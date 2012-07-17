package com.sowhoo.common.message;

public class TextMessage extends Message<MessageHeader,StringMessageContent>{

	private static final long serialVersionUID = 7574079837193685305L;
	
	public TextMessage(MessageHeader header, String content){
		this.header = header;
		this.content = new StringMessageContent(content);
	}
}
