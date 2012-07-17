package com.sowhoo.common.message;

public abstract class MessageContent<Content> {
	
	protected Content content;
	
	public Content getContent() {
		return content;
	}
	
	public void setContent(Content content) {
		this.content = content;
	}
}
