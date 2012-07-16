package com.sowhoo.common.message;

import java.io.Serializable;

public abstract class Message<Header,Content> implements Serializable{

	private static final long serialVersionUID = -115010973827269573L;

	protected Header header;
	protected Content content;
	
	public Header getHeader() {
		return header;
	}
	public Content getContent() {
		return content;
	}
	
}
