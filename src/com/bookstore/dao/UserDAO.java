package com.bookstore.dao;

import static com.bookstoredb.utils.Constants.COUNT_ALL_USERS;
import static com.bookstoredb.utils.Constants.FIND_ALL_USERS;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstoredb.entity.Users;;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		return super.update(user);
	}

	@Override
	public Users get(Object userId) {
		return super.find(Users.class, userId);
	}

	@Override
	public void delete(Object userId) {
		super.delete(Users.class, userId);
	}

	@Override
	public List<Users> listAll() {
		return super.findAllWithNamedQuery(FIND_ALL_USERS);
	}

	@Override
	public Long count() {
		return super.findCountWithNamedQuery(COUNT_ALL_USERS);
	}

}
