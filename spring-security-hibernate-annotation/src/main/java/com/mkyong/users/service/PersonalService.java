package com.mkyong.users.service;

import java.util.List;

import com.mkyong.users.model.Personal;


public interface PersonalService {
	
	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();
/*
	public void deleteUser(Integer userId);

	public User getUser(int userId);

	public User updateUser(User user);*/
}
