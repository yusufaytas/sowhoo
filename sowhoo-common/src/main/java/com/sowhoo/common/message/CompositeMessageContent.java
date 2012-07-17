package com.sowhoo.common.message;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class CompositeMessageContent extends MessageContent<List<MessageContent>>{
	
	public CompositeMessageContent(){
		content = new ArrayList<MessageContent>();
	}
}
