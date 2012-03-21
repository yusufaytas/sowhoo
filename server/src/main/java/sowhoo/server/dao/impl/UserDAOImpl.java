package sowhoo.server.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sowhoo.server.dao.UserDAO;
import sowhoo.server.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public String find(String email) {
		String query = "SELECT * FROM User WHERE email ='"+email+"'";
		User user = (User)sessionFactory.getCurrentSession().createSQLQuery(query).list().get(0);
		return user.getIp();
	}

}
