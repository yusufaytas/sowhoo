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
 * File : MessageReciever.java
 */
package com.sowhoo.speer.message;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sowhoo.common.message.Message;
import com.sowhoo.common.message.MessageHeader;
import com.sowhoo.common.serialization.Deserializer;

@Scope
@Component
public class MessageReciever {

	@Autowired
	protected MessageProcessor messageProcessor;
	
	protected ServerSocket speerSocket;
	protected volatile boolean isRunning = true;
	
	public int start(){
		try {
			if(isRunning){
				speerSocket = new ServerSocket();
				initialize();
			}
			else
				isRunning = true;
			return speerSocket.getLocalPort();
		} catch (IOException e) {
			return -1;
		}
	}

	public void stop(){
		isRunning = false;
	}
	
	public void initialize(){
		byte[] data;
		Socket peerSocket = null;
		while(isRunning) {
			try	{
				peerSocket= speerSocket.accept();
				if(peerSocket != null)	{
					DataInputStream dis = new DataInputStream(peerSocket.getInputStream());
					data = new byte[0];
					dis.read(data);
					Message<MessageHeader,?> message = Deserializer.deseralize(data);;
					messageProcessor.processMessage(message);
				}
			}
			catch(Exception e) {
				
			}
		}
	}
	
}
