package com.bookstoredb.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {

	public static void main(String[] args) {

		//1. Create entity manager factory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite"); //Mention persistence unit name

		//2. Create entity manager
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		//3. Create entity class object
		Category category = new Category();
		category.setName("Java");

		//4. Begin Transaction
		entityManager.getTransaction().begin();

		//5. Persist the user object into transaction
		entityManager.persist(category);

		//6. commit the transaction
		entityManager.getTransaction().commit();

		//7. close entity manager
		entityManager.close();

		//8. close entity manager factory
		entityManagerFactory.close();

		System.out.println("A Users object was persisted");
	}

}
