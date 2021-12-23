package com.bookstore.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

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
	
	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("David1@gmail.com");
		user1.setFullName("david");
		user1.setPassword("david@123");

		user1 = userDao.create(user1);
		
		assertTrue(user1.getUserId() > 0);
		assertEquals(user1.getFullName(), "david");
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users user1 = new Users();
		user1 = userDao.create(user1);
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
	
	@Test
	public void testGetUsers() {
		Users user = userDao.get(1);
		assertNotNull(user);
	}
	
	@Test
	public void testGetNonExistingUsers() {
		Users user = userDao.get(99999999);
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Users user = new Users();
		user.setEmail("David1999@gmail.com");
		user.setFullName("david");
		user.setPassword("david@12345");

		user = userDao.create(user);
		assertNotNull(user.getUserId());
		
		userDao.delete(user.getUserId());
		
		Users deletedUser = userDao.get(user.getUserId());
		assertNull(deletedUser);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNonExistingUsers() {
		userDao.delete(99999999);
	}
	
	@Test
	public void testListAll() {
		List<Users> users = userDao.listAll();
		assertTrue(users.size() > 1);
	}
	

	@Test
	public void testCount() {
		Long numberOfUsers = userDao.count();
		assertTrue(numberOfUsers > 0);
	}
	
	@AfterClass
	public static void after() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
