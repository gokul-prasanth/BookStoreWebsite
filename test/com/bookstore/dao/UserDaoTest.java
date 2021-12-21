package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstoredb.entity.Users;

public class UserDaoTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDao;
	
	@BeforeClass
	public static void setup() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite"); //Mention persistence unit name
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDAO(entityManager);
	}
	
	//@Test
	public void testCreateUsers() {
		
		Users user1 = new Users();
		user1.setEmail("David1@gmail.com");
		user1.setFullName("david");
		user1.setPassword("david@123");

		user1 = userDao.create(user1);
		
		assertTrue(user1.getUserId() > 0);
		assertEquals(user1.getFullName(), "david");
	}
	
	@Test
	public void testUpdateUsers() {
		
		Users user1 = new Users();
		user1.setUserId(10);
		user1.setEmail("David123@gmail.com");
		user1.setFullName("david");
		user1.setPassword("david@123");
		
		user1 = userDao.update(user1);
		
		assertTrue(user1.getUserId() > 0);
		assertEquals(user1.getEmail(), "David123@gmail.com");
	}
	
	@AfterClass
	public static void after() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
