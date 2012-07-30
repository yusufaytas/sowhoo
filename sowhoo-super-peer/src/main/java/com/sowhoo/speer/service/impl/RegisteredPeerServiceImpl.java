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
import com.sowhoo.speer.model.RegisteredPeer;
import com.sowhoo.speer.service.RegisteredPeerService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class RegisteredPeerServiceImpl implements RegisteredPeerService {

	@Autowired
	RegisteredPeerDAO registeredPeerDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public int update(RegisteredPeer registeredPeer){
		RegisteredPeer foundPeer = registeredPeerDAO.find(registeredPeer.getEmail());
		if(foundPeer==null)
			return -1;
		else if(foundPeer.equals(registeredPeer)){
			registeredPeerDAO.save(registeredPeer);
			return 1;
		}
		else
			return -1;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public int save(RegisteredPeer user){
		RegisteredPeer registeredPeer = registeredPeerDAO.find(user.getEmail());
		if(registeredPeer==null){
			registeredPeerDAO.save(user);
			return 1;
		}
		else
			return -1;
	}
	
	@Transactional
	public RegisteredPeer find(String email){
		return registeredPeerDAO.find(email);
	}

	public RegisteredPeerDAO getRegisteredPeerDAO() {
		return registeredPeerDAO;
	}

	public void setRegisteredPeerDAO(RegisteredPeerDAO registeredPeerDAO) {
		this.registeredPeerDAO = registeredPeerDAO;
	}

}
