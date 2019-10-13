package com.lti.training.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.training.hibernate.entity.Account;
import com.lti.training.hibernate.entity.Song;

public class AlbumDao extends GenericDao {
	

	public List<Song> fetchSongByName(String type) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("hiboracle");
			em = emf.createEntityManager();
			String jpql = "select s from Song s where s.title = :tp";
			Query q = em.createQuery(jpql);
			q.setParameter("tp", type);
			return q.getResultList();
		} finally {
			em.close();
			emf.close();
		}
	}
	

}
