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
 * File : RegisteredPeerDAOTest.java
 */
package com.sowhoo.speer.dao.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.sowhoo.speer.builder.RegisteredPeerBuilder;
import com.sowhoo.speer.dao.impl.RegisteredPeerDAOImpl;
import com.sowhoo.speer.model.RegisteredPeer;

@RunWith( MockitoJUnitRunner.class ) 
public class RegisteredPeerDAOTest {

	@Spy
	RegisteredPeerDAOImpl registeredPeerDAO = new RegisteredPeerDAOImpl();
	
	@Mock
	SessionFactory sessionFactory;
	
	@Mock
	Session session;
	
	@Mock
	SQLQuery sqlQuery;
	
	@Spy
	List<RegisteredPeer> list = new ArrayList<RegisteredPeer>();
	
	private RegisteredPeer peer;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		peer = new RegisteredPeerBuilder().email("email").build();
		registeredPeerDAO.setSessionFactory(sessionFactory);
	}
	
	@Test
	public void saveTest(){
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		doNothing().when(session).saveOrUpdate(peer);
		registeredPeerDAO.save(peer);
		verify(sessionFactory).getCurrentSession();
		verify(session).saveOrUpdate(peer);
	}
	
	@Test
	public void deleteTest(){
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		doNothing().when(session).delete(peer);
		registeredPeerDAO.delete(peer);
		verify(sessionFactory).getCurrentSession();
		verify(session).delete(peer);
	}
	
	@Test
	public void findTest(){
		String email = "email";
		String query = "SELECT * FROM sowhoopeer WHERE pemail ='"+email+"'";
		doReturn(sqlQuery).when(registeredPeerDAO).createQuery(query, RegisteredPeer.class);
		when(sqlQuery.list()).thenReturn(list);
		doReturn(peer).when(list).get(0);
		RegisteredPeer actualPeer = registeredPeerDAO.find(email);
		assertEquals(peer, actualPeer);
	}
	
	@Test
	public void findThrowsExceptionTest(){
		String email = "email";
		String query = "SELECT * FROM sowhoopeer WHERE pemail ='"+email+"'";
		doReturn(sqlQuery).when(registeredPeerDAO).createQuery(query, RegisteredPeer.class);
		when(sqlQuery.list()).thenReturn(list);
		doThrow(new IndexOutOfBoundsException()).when(list).get(0);
		RegisteredPeer actualPeer = registeredPeerDAO.find(email);
		assertEquals(null, actualPeer);
	}
}
