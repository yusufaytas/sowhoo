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
 * File : RegisteredPeer.java
 */
package com.sowhoo.speer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

@Indexed
@Entity
@Table(name = "RegisteredPeer")
public class RegisteredPeer {
	
	@Id
	@DocumentId
	@Column(name = "rpEmail")
	private String email;
	
	@Column(name = "rpIp")
	private String ip;
	
	@Column(name = "rpPassword")
	private String password;
	
	@Column(name = "rpPort")
	private String port;
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPassword() {
		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(RegisteredPeer peer){
		return (this.email.equals(peer.getEmail())&&this.password.equals(peer.getPassword()));
	}
}
