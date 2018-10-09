package com.mkyong.users.dao;

import java.util.List;

import com.mkyong.users.model.User;

public interface PersonalDao {

	User findByUserName(String username);
	
/*	public void addUser(User user);

	public List<User> getAllUsers();

	public void deleteUser(Integer userId);

	public User updateUser(User user);

	public User getUser(int userId);*/

}