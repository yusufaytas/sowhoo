package com.sowhoo.speer.service.impl;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.sowhoo.speer.builder.RegisteredPeerBuilder;
import com.sowhoo.speer.dao.RegisteredPeerDAO;
import com.sowhoo.speer.exception.NoRegisteredPeerException;
import com.sowhoo.speer.exception.PeerAlreadyExistException;
import com.sowhoo.speer.exception.UnAuthorizedPeerException;
import com.sowhoo.speer.model.RegisteredPeer;

public class RegisteredPeerServiceTest {
	
	@Spy
	RegisteredPeerServiceImpl registeredPeerService = new RegisteredPeerServiceImpl();

	@Mock
	RegisteredPeerDAO registeredPeerDAO;
	
	@Spy
	private RegisteredPeer peer = new RegisteredPeerBuilder().email("email").password("password").build();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		registeredPeerService.setRegisteredPeerDAO(registeredPeerDAO);
	}
	
	public void updateTest() throws UnAuthorizedPeerException, NoRegisteredPeerException{
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(peer);
		doNothing().when(registeredPeerDAO).save(peer);
		registeredPeerService.update(peer);
		verify(registeredPeerDAO).save(peer);
	}
	
	@Test(expected=NoRegisteredPeerException.class)
	public void updateTestThrowsNoRegisteredPeerException() throws UnAuthorizedPeerException, NoRegisteredPeerException{
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(null);
		registeredPeerService.update(peer);
	}
	
	@Test(expected=UnAuthorizedPeerException.class)
	public void updateTestThrowsUnAuthorizedRegisteredPeerException() throws UnAuthorizedPeerException, NoRegisteredPeerException{
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(peer);
		doReturn(false).when(peer).equals(peer);
		registeredPeerService.update(peer);
	}
	
	public void saveTest() throws PeerAlreadyExistException{
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(null);
		doNothing().when(registeredPeerDAO).save(peer);
		registeredPeerService.save(peer);
		verify(registeredPeerDAO).save(peer);
	}
	
	@Test(expected=PeerAlreadyExistException.class)
	public void saveThrowsPeerAlreadyExistException() throws PeerAlreadyExistException{
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(peer);
		registeredPeerService.save(peer);
	}
	
	@Test
	public void findTest(){
		String email = "email";
		peer.setIp("192.123.23.1");
		when(registeredPeerDAO.find(email)).thenReturn(peer);
		String actualIp = registeredPeerService.find(email);
		assertEquals(peer.getIp(),actualIp);
	}
}
