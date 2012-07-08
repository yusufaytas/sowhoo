package com.sowhoo.speer.dao;

import com.sowhoo.speer.model.User;

public interface UserDAO {
	public void save(User user);
	public User find(String email);
}
