package com.sowhoo.speer.service;

import com.sowhoo.speer.exception.NoPeerException;
import com.sowhoo.speer.exception.UnAuthorizedPeerException;
import com.sowhoo.speer.exception.PeerAlreadyExistException;
import com.sowhoo.speer.model.Peer;

public interface PeerService {
	public void update(Peer peer) throws UnAuthorizedPeerException,NoPeerException;
	public void save(Peer peer) throws PeerAlreadyExistException;
}
