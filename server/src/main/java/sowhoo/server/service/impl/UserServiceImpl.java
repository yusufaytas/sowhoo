package sowhoo.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sowhoo.server.dao.UserDAO;
import sowhoo.server.model.User;
import sowhoo.server.service.UserService;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(User user) {
		userDAO.save(user);
	}
	
	@Transactional
	public String discover(String email){
		return userDAO.find(email);
	}
}
