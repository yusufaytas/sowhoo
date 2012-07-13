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
 * File : NeighborPeerServiceImpl.java
 */
package com.sowhoo.peer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sowhoo.peer.dao.NeighborPeerDAO;
import com.sowhoo.peer.service.NeighborPeerService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class NeighborPeerServiceImpl implements NeighborPeerService {

	@Autowired
	NeighborPeerDAO neighborPeerDAO;
	
}
