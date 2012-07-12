package com.sowhoo.speer.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowhoo.speer.dao.PeerDAO;
import com.sowhoo.speer.model.Peer;

@Repository
public class PeerDAOImpl implements PeerDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Peer peer) {
		sessionFactory.getCurrentSession().saveOrUpdate(peer);
	}
	
	public void delete(Peer peer) {
		sessionFactory.getCurrentSession().delete(peer);
	}

	public Peer find(String email) {
		Peer user = null;
		String query = "SELECT * FROM sowhoouser WHERE uemail ='"+email+"'";
		try{
			user = (Peer)sessionFactory.getCurrentSession().
			createSQLQuery(query).addEntity(Peer.class).list().get(0);
		}catch(Exception ex){
			System.out.println(ex);
		};
		return user;
	}

}
