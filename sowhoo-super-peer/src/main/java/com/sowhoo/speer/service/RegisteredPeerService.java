/*************************************************************************
 * Yusuf Aytas  � All Rights Reserved.
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
 * File : RegisteredPeerService.java
 */
package com.sowhoo.speer.service;

import com.sowhoo.speer.exception.NoRegisteredPeerException;
import com.sowhoo.speer.exception.UnAuthorizedPeerException;
import com.sowhoo.speer.exception.PeerAlreadyExistException;
import com.sowhoo.speer.model.RegisteredPeer;

public interface RegisteredPeerService {
	public void update(RegisteredPeer peer) throws UnAuthorizedPeerException,NoRegisteredPeerException;
	public void save(RegisteredPeer peer) throws PeerAlreadyExistException;
	public String find(String email) throws NoRegisteredPeerException;
}
