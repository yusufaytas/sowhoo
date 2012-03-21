package sowhoo.server.dao;

import sowhoo.server.model.User;

public interface UserDAO {
	public void save(User user);
	public void delete(User user);
	public User find(String email);
}
