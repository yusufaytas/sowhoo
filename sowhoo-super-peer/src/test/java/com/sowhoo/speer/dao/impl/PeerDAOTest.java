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

import com.sowhoo.speer.builder.PeerBuilder;
import com.sowhoo.speer.dao.impl.PeerDAOImpl;
import com.sowhoo.speer.model.Peer;

@RunWith( MockitoJUnitRunner.class ) 
public class PeerDAOTest {

	@Spy
	PeerDAOImpl peerDAO = new PeerDAOImpl();
	
	@Mock
	SessionFactory sessionFactory;
	
	@Mock
	Session session;
	
	@Mock
	SQLQuery sqlQuery;
	
	@Spy
	List<Peer> list = new ArrayList<Peer>();
	
	private Peer peer;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		peer = new PeerBuilder().email("email").build();
		peerDAO.setSessionFactory(sessionFactory);
	}
	
	@Test
	public void saveTest(){
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		doNothing().when(session).saveOrUpdate(peer);
		peerDAO.save(peer);
		verify(sessionFactory).getCurrentSession();
		verify(session).saveOrUpdate(peer);
	}
	
	@Test
	public void deleteTest(){
		when(sessionFactory.getCurrentSession()).thenReturn(session);
		doNothing().when(session).delete(peer);
		peerDAO.delete(peer);
		verify(sessionFactory).getCurrentSession();
		verify(session).delete(peer);
	}
	
	@Test
	public void findTest(){
		String email = "email";
		String query = "SELECT * FROM sowhoopeer WHERE pemail ='"+email+"'";
		doReturn(sqlQuery).when(peerDAO).createQuery(query, Peer.class);
		when(sqlQuery.list()).thenReturn(list);
		doReturn(peer).when(list).get(0);
		Peer actualPeer = peerDAO.find(email);
		assertEquals(peer, actualPeer);
	}
	
	@Test
	public void findThrowsExceptionTest(){
		String email = "email";
		String query = "SELECT * FROM sowhoopeer WHERE pemail ='"+email+"'";
		doReturn(sqlQuery).when(peerDAO).createQuery(query, Peer.class);
		when(sqlQuery.list()).thenReturn(list);
		doThrow(new IndexOutOfBoundsException()).when(list).get(0);
		Peer actualPeer = peerDAO.find(email);
		assertEquals(null, actualPeer);
	}
}
