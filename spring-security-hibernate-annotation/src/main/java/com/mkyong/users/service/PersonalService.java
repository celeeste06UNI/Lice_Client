package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Personal;
import com.mkyong.users.model.User;
import com.mkyong.users.model.UserRole;


public interface PersonalService {
	
	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();
/*
	public void deleteUser(Integer userId);

	public User getUser(int userId);

	public User updateUser(User user);*/

	public void addUser(User user);

	public void addUserRole(User user, String role);
}
