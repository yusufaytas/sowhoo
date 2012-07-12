package com.sowhoo.speer.dao.impl;

import org.hibernate.SQLQuery;
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
		Peer peer = null;
		String query = "SELECT * FROM sowhoopeer WHERE pemail ='"+email+"'";
		try{
			SQLQuery sqlQuery = createQuery(query,Peer.class);
			peer = (Peer)sqlQuery.list().get(0);
		}catch(Exception ex){};
		return peer;
	}

	@SuppressWarnings("rawtypes")
	protected SQLQuery createQuery(String query,Class c) {
		return sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(c);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
