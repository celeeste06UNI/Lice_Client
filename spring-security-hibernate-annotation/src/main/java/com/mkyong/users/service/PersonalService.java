package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Personal;
import com.mkyong.users.model.User;



public interface PersonalService {
	
/*
	public void deleteUser(Integer userId);

	public User getUser(int userId);

	public User updateUser(User user);*/
	public List<Personal> getAllPersonal();
	
	public void addPersonal(Personal personal, String passNoEncryp);

	public void addUser(User user);

	public void addUserRole(User user, String role);

	public void deletePersonal(Integer id);

	public void deleteUser(String username);

	public void updatePersonal(Personal personal);

	public Personal getPersonal(Integer id);
	


}
