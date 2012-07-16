package com.sowhoo.speer.message;

import org.springframework.stereotype.Component;

import com.sowhoo.common.message.StringMessage;

@Component
public class MessageProcessor {

	public void processMessage(StringMessage message){
		switch(message.getHeader()){
		case DEFAULT :
		}
	}
}
