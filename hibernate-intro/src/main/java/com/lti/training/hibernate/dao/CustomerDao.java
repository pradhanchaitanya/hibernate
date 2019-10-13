package com.lti.training.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.lti.training.hibernate.entity.Customer;

public class CustomerDao {
	
	
		
	public void add(Customer customer) {
		//Step 1. Load/Create EntityManagerFActory object
		//During this step, Meta -INF/persistence.xml file will be read
		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("hirboracle");
		//step 2. Load/create EntityManager object
		//creating this object is like opening a connection in JDBC
		EntityManager em = emf.createEntityManager();
		
		
		//step3. Start/participate in a Transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
               //Now we can perform any insert/update/delete/select operation 
		em.persist(customer);//persist method generates insert query
		tx.commit();
		em.close();
		emf.close();
		}
	public void update(Customer customer) {
		EntityManagerFactory emf =	Persistence.createEntityManagerFactory("hirboracle");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
               //Now we can perform any insert/update/delete/select operation 
		em.merge(customer);//persist method generates insert query
		tx.commit();
		em.close();
		emf.close();
		}
	
	
	public Customer fetchById(int customerId){
		EntityManagerFactory emf = null;
		EntityManager em = null;

	try {
		emf =	Persistence.createEntityManagerFactory("hirboracle");
		em = emf.createEntityManager();
		Customer c = em.find(Customer.class, customerId);
		return c;
	}finally {
	em.close();
	emf.close();
	}
	
}

}