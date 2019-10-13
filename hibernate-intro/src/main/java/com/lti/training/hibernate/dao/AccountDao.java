package com.lti.training.hibernate.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.training.hibernate.entity.Account;
import com.lti.training.hibernate.entity.Transaction;

public class AccountDao extends GenericDao {

	public List<Account> fetchAccountsByType(String type) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("hiboracle");
			em = emf.createEntityManager();
			
			// introducing HQL/JPQL
			// select * from TBL_ACCOUNT where ACC_TYPE = 'Savings'
			
			String jpql = "select a from Account a where a.type = :tp";
			Query q = em.createQuery(jpql);
			q.setParameter("tp", type);
			return q.getResultList();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Account> fetchAccountsByBalance(double balance) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("hiboracle");
			em = emf.createEntityManager();
			
			// introducing HQL/JPQL
			// select * from TBL_ACCOUNT where ACC_TYPE = 'Savings'
			
			String jpql = "select a from Account a where a.balance > :tp";
			Query q = em.createQuery(jpql);
			q.setParameter("tp", balance);
			return q.getResultList();
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Transaction> fetchStatement(long acno) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("hiboracle");
			em = emf.createEntityManager();
			
			// introducing HQL/JPQL
			// select * from tbl_txn where acno="";
			
			String jpql = "select t from Transaction t where t.account.accountNo = :tp";
			Query q = em.createQuery(jpql);
			q.setParameter("tp", acno);
			return q.getResultList();
		} finally {
			em.close();
			emf.close();
		}
	}
}
