package com.sowhoo.speer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sowhoo.speer.dao.PeerDAO;
import com.sowhoo.speer.exception.NoPeerException;
import com.sowhoo.speer.exception.UnAuthorizedPeerException;
import com.sowhoo.speer.exception.PeerAlreadyExistException;
import com.sowhoo.speer.model.Peer;
import com.sowhoo.speer.service.PeerService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class PeerServiceImpl implements PeerService {

	@Autowired
	PeerDAO peerDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(Peer peer) throws UnAuthorizedPeerException,NoPeerException {
		Peer hPeer = peerDAO.find(peer.getEmail());
		if(hPeer==null)
			throw new NoPeerException();
		else if(hPeer.equals(peer))
			peerDAO.save(peer);
		else
			throw new UnAuthorizedPeerException();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void save(Peer user) throws PeerAlreadyExistException {
		Peer hPeer = peerDAO.find(user.getEmail());
		if(hPeer==null)
			throw new PeerAlreadyExistException();
		else
			peerDAO.save(user);
	}
	
	@Transactional
	public String discover(String email){
		return peerDAO.find(email).getIp();
	}

}
