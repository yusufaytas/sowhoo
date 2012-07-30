package com.sowhoo.speer.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.sowhoo.speer.builder.RegisteredPeerBuilder;
import com.sowhoo.speer.dao.RegisteredPeerDAO;
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
	
	public void updateTest(){
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(peer);
		doNothing().when(registeredPeerDAO).save(peer);
		int returnValue = registeredPeerService.update(peer);
		assertEquals(returnValue, 1);
		verify(registeredPeerDAO).save(peer);
	}
	
	@Test
	public void updateTestThrowsNoRegisteredPeerException(){
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(null);
		int returnValue = registeredPeerService.update(peer);
		assertEquals(returnValue, -1);
	}
	
	@Test
	public void updateTestThrowsUnAuthorizedRegisteredPeerException(){
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(peer);
		doReturn(false).when(peer).equals(peer);
		int returnValue = registeredPeerService.update(peer);
		assertEquals(returnValue, -1);
	}
	
	public void saveTest(){
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(null);
		doNothing().when(registeredPeerDAO).save(peer);
		int returnValue = registeredPeerService.update(peer);
		assertEquals(returnValue, 1);
		verify(registeredPeerDAO).save(peer);
	}
	
	@Test
	public void saveThrowsPeerAlreadyExistException(){
		String email = "email";
		when(registeredPeerDAO.find(email)).thenReturn(peer);
		int returnValue = registeredPeerService.update(peer);
		assertEquals(returnValue, -1);
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
