package com.sowhoo.speer.service;

import com.sowhoo.speer.exception.NoSuchUserException;
import com.sowhoo.speer.exception.UnAuthorizedUserException;
import com.sowhoo.speer.exception.UserAlreadyExistException;
import com.sowhoo.speer.model.User;

public interface UserService {
	public void update(User user) throws UnAuthorizedUserException,NoSuchUserException;
	public void save(User user) throws UserAlreadyExistException;
}
