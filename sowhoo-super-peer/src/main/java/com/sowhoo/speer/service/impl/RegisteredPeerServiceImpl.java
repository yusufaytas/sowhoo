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
 * File : RegisteredPeerServiceImpl.java
 */
package com.sowhoo.speer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sowhoo.speer.dao.RegisteredPeerDAO;
import com.sowhoo.speer.exception.NoRegisteredPeerException;
import com.sowhoo.speer.exception.UnAuthorizedRegisteredPeerException;
import com.sowhoo.speer.exception.RegisteredPeerAlreadyExistException;
import com.sowhoo.speer.model.RegisteredPeer;
import com.sowhoo.speer.service.RegisteredPeerService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class RegisteredPeerServiceImpl implements RegisteredPeerService {

	@Autowired
	RegisteredPeerDAO registeredPeerDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(RegisteredPeer registeredPeer) throws UnAuthorizedRegisteredPeerException,NoRegisteredPeerException {
		RegisteredPeer hPeer = registeredPeerDAO.find(registeredPeer.getEmail());
		if(hPeer==null)
			throw new NoRegisteredPeerException();
		else if(hPeer.equals(registeredPeer))
			registeredPeerDAO.save(registeredPeer);
		else
			throw new UnAuthorizedRegisteredPeerException();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void save(RegisteredPeer user) throws RegisteredPeerAlreadyExistException {
		RegisteredPeer registeredPeer = registeredPeerDAO.find(user.getEmail());
		if(registeredPeer==null)
			throw new RegisteredPeerAlreadyExistException();
		else
			registeredPeerDAO.save(user);
	}
	
	@Transactional
	public String find(String email){
		return registeredPeerDAO.find(email).getIp();
	}

}
