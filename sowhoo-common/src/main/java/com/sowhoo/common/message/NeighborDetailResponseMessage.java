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
 * File : NeighborDetailResponseMessage.java
 */
package com.sowhoo.common.message;

public class NeighborDetailResponseMessage extends Message<MessageHeader, MessageContent<String>>{
	
	private static final long serialVersionUID = -9142558195167227031L;
	
	private String ip;
	private int port;
	
	public NeighborDetailResponseMessage(){
		this.header.setMessageType(MessageType.NEIGHBOR_CONNECTION_DETAIL_RESPONSE);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
