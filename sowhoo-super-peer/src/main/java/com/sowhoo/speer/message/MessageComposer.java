/*************************************************************************
 * Yusuf Aytas  © All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains the property 
 * of Yusuf Aytas and its suppliers,if any.  The intellectual and 
 * technical concepts contained herein are proprietary to Yusuf Aytas
 * and its suppliers and may be covered by U.S. and Foreign Patents,patents
 * in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material is 
 * strictly forbidden unless prior written permission is obtained
 * from Yusuf Aytas.
 * Author : Yusuf Aytas
 * Date : Jul 30, 2012
 * File : MessageComposer.java
 */
package com.sowhoo.speer.message;

import org.springframework.stereotype.Component;

import com.sowhoo.common.message.ErrorMessage;
import com.sowhoo.common.message.MessageHeader;
import com.sowhoo.common.message.NeighborResponseMessage;
import com.sowhoo.speer.model.RegisteredPeer;

@Component
public class MessageComposer {
	
	public ErrorMessage composeErrorMessage(MessageHeader messageHeader,Integer errorCode){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(errorCode);
		MessageHeader newMessageHeader = changeDirection(messageHeader);
		errorMessage.setHeader(newMessageHeader);
		return errorMessage;
	}
	
	public MessageHeader changeDirection(MessageHeader messageHeader){
		MessageHeader newMessageHeader = new MessageHeader();
		newMessageHeader.setSourceId(messageHeader.getTargetIp());
		newMessageHeader.setSourcePort(messageHeader.getTargetPort());
		newMessageHeader.setTargetIp(messageHeader.getSourceIp());
		newMessageHeader.setTargetPort(messageHeader.getSourcePort());
		newMessageHeader.setSourceId(messageHeader.getTargetId());
		newMessageHeader.setTargetId(messageHeader.getSourceId());
		return newMessageHeader;
	}

	public NeighborResponseMessage composeNeighborResponseMessage(MessageHeader messageHeader,RegisteredPeer registeredPeer) {
		NeighborResponseMessage neighborResponseMessage = new NeighborResponseMessage();
		neighborResponseMessage.setIp(registeredPeer.getIp());
		neighborResponseMessage.setPort(registeredPeer.getPort());
		MessageHeader newMessageHeader = changeDirection(messageHeader);
		neighborResponseMessage.setHeader(newMessageHeader);
		return neighborResponseMessage;
	}
}
