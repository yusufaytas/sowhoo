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
 * File : MessageProcessor.java
 */
package com.sowhoo.speer.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sowhoo.common.message.ErrorMessage;
import com.sowhoo.common.message.IpUpdateMessage;
import com.sowhoo.common.message.Message;
import com.sowhoo.common.message.MessageHeader;
import com.sowhoo.common.message.NeighborDetailRequestMessage;
import com.sowhoo.common.message.NeighborDetailResponseMessage;
import com.sowhoo.speer.model.RegisteredPeer;
import com.sowhoo.speer.service.RegisteredPeerService;

@Component
public class MessageProcessor {

	@Autowired
	RegisteredPeerService service;

	@Autowired
	MessageComposer messageComposer;

	@Autowired
	MessageSender messageSender;

	public void processMessage(Message<MessageHeader, ?> message) {
		switch (message.getHeader().getMessageType()) {
		case IP_UPDATE: {
			IpUpdateMessage ipUpdateMessage = (IpUpdateMessage) message;
			RegisteredPeer registeredPeer = new RegisteredPeer();
			registeredPeer.setIp(ipUpdateMessage.getHeader().getSourceIp());
			registeredPeer.setPort(ipUpdateMessage.getHeader().getSourcePort());
			registeredPeer.setEmail(ipUpdateMessage.getEmail());
			registeredPeer.setPassword(ipUpdateMessage.getPassword());
			int returnValue = service.update(registeredPeer);
			if (returnValue != 1) {
				ErrorMessage newMessage = messageComposer.composeErrorMessage(message.getHeader(), returnValue);
				messageSender.sendMessage(newMessage);
			}
		}
			break;
		case NEIGHBOR_CONNECTION_DETAIL_REQUEST: {
			NeighborDetailRequestMessage neighborRequestMessage = (NeighborDetailRequestMessage) message;
			RegisteredPeer registeredPeer = service.find(neighborRequestMessage.getEmail());
			if (registeredPeer != null) {
				NeighborDetailResponseMessage neighborResponseMessage = messageComposer.composeNeighborResponseMessage(neighborRequestMessage.getHeader(), registeredPeer);
				messageSender.sendMessage(neighborResponseMessage);
			}
		}
			break;
		}
	}
}
