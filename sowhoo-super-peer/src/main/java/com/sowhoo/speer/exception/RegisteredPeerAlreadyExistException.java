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
 * Date : Jul 13, 2012
 * File : RegisteredPeerAlreadyExistException.java
 */
package com.sowhoo.speer.exception;

public class RegisteredPeerAlreadyExistException extends Exception{

	private static final long serialVersionUID = 3198784535050328757L;

	public RegisteredPeerAlreadyExistException(){
		super();
	}
	
	public RegisteredPeerAlreadyExistException(String message){
		super(message);
	}
}
