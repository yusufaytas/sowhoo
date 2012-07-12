package com.sowhoo.speer.builder;

import com.sowhoo.speer.model.Peer;

public class PeerBuilder {
	
	private String email;
	
	public Peer build(){
		Peer peer = new Peer();
		peer.setEmail(email);
		return peer;
	}
	
	public PeerBuilder email(String email){
		this.email = email;
		return this;
	}
}
