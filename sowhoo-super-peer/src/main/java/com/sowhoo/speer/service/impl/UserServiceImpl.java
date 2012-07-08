package com.sowhoo.speer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sowhoo.speer.dao.UserDAO;
import com.sowhoo.speer.exception.NoSuchUserException;
import com.sowhoo.speer.exception.UnAuthorizedUserException;
import com.sowhoo.speer.exception.UserAlreadyExistException;
import com.sowhoo.speer.model.User;
import com.sowhoo.speer.service.UserService;


@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(User user) throws UnAuthorizedUserException,NoSuchUserException {
		User hUser = userDAO.find(user.getEmail());
		if(hUser==null)
			throw new NoSuchUserException();
		else if(hUser.equals(user))
			userDAO.save(user);
		else
			throw new UnAuthorizedUserException();
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void save(User user) throws UserAlreadyExistException {
		User hUser = userDAO.find(user.getEmail());
		if(hUser==null)
			throw new UserAlreadyExistException();
		else
			userDAO.save(user);
	}
	
	@Transactional
	public String discover(String email){
		return userDAO.find(email).getIp();
	}

}
