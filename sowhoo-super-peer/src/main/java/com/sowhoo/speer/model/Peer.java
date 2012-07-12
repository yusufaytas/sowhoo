package com.sowhoo.speer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;

@Indexed
@Entity
@Table(name = "sowhoopeer")
public class Peer {
	
	@Id
	@DocumentId
	@Column(name = "pemail")
	private String email;
	
	@Column(name = "pip")
	private String ip;
	
	@Column(name = "ppassword")
	private String password;
	
	@Column(name = "pport")
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
	
	public boolean equals(Peer peer){
		return (this.email.equals(peer.getEmail())&&this.password.equals(peer.getPassword()));
	}
}
