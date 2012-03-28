package sowhoo.server.service;

import sowhoo.server.exception.NoSuchUserException;
import sowhoo.server.exception.UnAuthorizedUserException;
import sowhoo.server.exception.UserAlreadyExistException;
import sowhoo.server.model.User;

public interface UserService {
	public void update(User user) throws UnAuthorizedUserException,NoSuchUserException;
	public void save(User user) throws UserAlreadyExistException;
}
