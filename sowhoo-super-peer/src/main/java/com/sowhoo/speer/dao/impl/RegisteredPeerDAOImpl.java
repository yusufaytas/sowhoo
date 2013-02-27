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
 * File : RegisteredPeerDAOImpl.java
 */
package com.sowhoo.speer.dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sowhoo.speer.dao.RegisteredPeerDAO;
import com.sowhoo.speer.model.RegisteredPeer;

@Repository
public class RegisteredPeerDAOImpl implements RegisteredPeerDAO {

	private static final Logger logger = LoggerFactory.getLogger(RegisteredPeerDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(RegisteredPeer registeredPeer) {
		sessionFactory.getCurrentSession().saveOrUpdate(registeredPeer);
	}

	public void delete(RegisteredPeer registeredPeer) {
		sessionFactory.getCurrentSession().delete(registeredPeer);
	}

	public RegisteredPeer find(String email) {
		RegisteredPeer registeredPeer = null;
		String query = "SELECT * FROM RegisteredPeer WHERE rpEmail ='" + email + "'";
		SQLQuery sqlQuery = createQuery(query, RegisteredPeer.class);
		registeredPeer = (RegisteredPeer) sqlQuery.list().get(0);
		return registeredPeer;
	}

	@SuppressWarnings("rawtypes")
	protected SQLQuery createQuery(String query, Class c) {
		return sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(c);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
