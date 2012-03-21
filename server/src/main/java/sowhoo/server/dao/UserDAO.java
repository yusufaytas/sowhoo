package sowhoo.server.dao;

import sowhoo.server.model.User;

public interface UserDAO {
	public void save(User user);
	public String find(String email);
}
