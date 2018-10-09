package com.mkyong.users.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mkyong.users.model.User;

@Repository
public class PersonalDaoImpl implements PersonalDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
				.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}
	
	/*public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@SuppressWarnings("unchecked")
	public List<Personal> getAll() {

		return sessionFactory.getCurrentSession().createQuery("from users")
				.list();
	}
*/

	/*public void deleteUser(Integer userId) {
		User user = (User) sessionFactory.getCurrentSession().load(
				User.class, userId);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}

	}

	public User getUser(int userId) {
		return (User) sessionFactory.getCurrentSession().get(
				User.class, userId);
	}


	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}


	

*/
}