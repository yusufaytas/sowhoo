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
 * File : MessageSender.java
 */
package com.sowhoo.speer.message;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import org.springframework.stereotype.Component;

import com.sowhoo.common.message.Message;
import com.sowhoo.common.message.MessageHeader;
import com.sowhoo.common.serialization.Serializer;

@Component
public class MessageSender {

	public void sendMessage(Message<MessageHeader,?> message) {
		byte [] messageBytes = Serializer.serialize(message);
		try {
			Socket socket = new Socket(message.getHeader().getTargetIp(),message.getHeader().getTargetPort());
			DataOutputStream dos;
			dos = new DataOutputStream(socket.getOutputStream());
			dos.write(messageBytes);
			dos.close();
			dos = null;
			socket = null;
		} catch (IOException e) {}
	}

}
