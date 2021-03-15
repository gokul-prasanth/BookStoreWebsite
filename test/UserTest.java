import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstoredb.entity.Users;

/**
 * @author Gokul A
 * @createdOn March 14, 2021
 */
public class UserTest {

	public static void main(String[] args) {

		//1. Create entity manager factory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite"); //Mention persistence unit name

		//2. Create entity manager
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		//3. Create entity class object
		Users user1 = new Users();
		user1.setEmail("jo112@gmail.com");
		user1.setFullName("Jothika");
		user1.setPassword("joSurya");

		//4. Begin Transaction
		entityManager.getTransaction().begin();

		//5. Persist the user object into transaction
		entityManager.persist(user1);

		//6. commit the transaction
		entityManager.getTransaction().commit();

		//7. close entity manager
		entityManager.close();

		//8. close entity manager factory
		entityManagerFactory.close();

		System.out.println("A Users object was persisted");
	}

}
