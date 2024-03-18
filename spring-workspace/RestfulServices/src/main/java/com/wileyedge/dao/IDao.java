package com.wileyedge.dao;

import java.util.List;
import java.util.Optional;

import com.wileyedge.model.User;

public interface IDao {
	public List<User> findAll();
	Optional<User> findById(int id);
	public User save(User user);
	public User deleteById(int id);
	public List<User> findByName(String name);
}
