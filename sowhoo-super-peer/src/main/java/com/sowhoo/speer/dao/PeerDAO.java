package com.sowhoo.speer.dao;

import com.sowhoo.speer.model.Peer;

public interface PeerDAO {
	public void save(Peer peer);
	public Peer find(String email);
}
