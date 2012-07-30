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
 * File : NeighborRequestMessage.java
 */
package com.sowhoo.common.message;

public class NeighborRequestMessage extends Message<MessageHeader, MessageContent<String>>{
	
	private static final long serialVersionUID = -623103502265096992L;
	
	private String email;
	
	public NeighborRequestMessage(){
		this.header.setMessageType(MessageType.NEIGHBORREQUEST);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
