package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstoredb.entity.Users;

public class UserServices {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDao;

	public UserServices() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDao = new UserDAO(entityManager);
	}

	public void listUsers(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Users> listAll = userDao.listAll();
		request.setAttribute("listUsers", listAll);
		String listPage = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void createUser(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		
		Users user = new Users(email, password, fullName);
		userDao.create(user);
	}
	
	public void editUser(Users user) {
		userDao.update(user);
	}
	
	public void deleteUser(Object userId) {
		userDao.delete(userId);  
	}


}
