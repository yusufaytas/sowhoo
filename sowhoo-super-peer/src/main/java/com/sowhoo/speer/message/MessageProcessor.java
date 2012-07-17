package com.sowhoo.speer.message;

import org.springframework.stereotype.Component;

import com.sowhoo.common.message.Message;
import com.sowhoo.common.message.MessageHeader;

@Component
public class MessageProcessor {

	public void processMessage(Message<MessageHeader,?> message){
		switch(message.getHeader().getMessageType()){
		case TEXTMESSAGE:
		}
	}
}
