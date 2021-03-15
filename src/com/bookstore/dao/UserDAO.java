package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstoredb.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public Users create(Users user) {
		return super.create(user);
	}

	@Override
	public Users update(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Users> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
