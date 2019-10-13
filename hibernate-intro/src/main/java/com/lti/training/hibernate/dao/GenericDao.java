package com.lti.training.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.training.hibernate.entity.Customer;

// BaseDao
// GenericDao

public class GenericDao {
	
	public void upsert(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("hiboracle");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.merge(obj);//merge method can be used for insert as well as update
			tx.commit();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	
	public Object fetchById(Class clazz,Object pk){
		EntityManagerFactory emf = null;
		EntityManager em = null;

	try {
		emf = Persistence.createEntityManagerFactory("hiboracle");
		em = emf.createEntityManager();
		Object o = em.find(clazz, pk);
		return o;
	} finally {
		em.close();
		emf.close();
	}
	
}
}
