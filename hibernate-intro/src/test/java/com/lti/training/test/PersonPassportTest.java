package com.lti.training.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.training.hibernate.dao.GenericDao;
import com.lti.training.hibernate.entity.Address;
import com.lti.training.hibernate.entity.Passport;
import com.lti.training.hibernate.entity.Person;

public class PersonPassportTest {
	@Test
	public void addPerson() {
		Person p =new Person();
		p.setDateOfBirth(LocalDate.now());
		p.setName("parth");
		GenericDao dao = new GenericDao();
		dao.upsert(p);
	}
	
	@Test
	public void addPassportForAPerson() {
		GenericDao dao = new GenericDao();
		Person p = (Person) dao.fetchById(Person.class, 141);
		
		Passport pass = new Passport();
		pass.setExpiryDate(LocalDate.now());
		pass.setIssueDate(LocalDate.of(2018,12,11));
		pass.setPassportNo("ABCD123456789");
		pass.setPerson(p);
		
		dao.upsert(pass);
	}
	@Test
	public void addPersonAlongWithPassport() {
		GenericDao dao = new GenericDao();
		Person p =new Person();
		p.setName("Dinesh");
		p.setDateOfBirth(LocalDate.of(1,1, 1));
		
		Passport pp = new Passport();
		pp.setIssueDate(LocalDate.of(2010,10,10));
		pp.setExpiryDate(LocalDate.of(2020,10,20));
		pp.setPassportNo("K123sds353");
		pp.setPerson(p);
		dao.upsert(pp);
		
	}
	@Test
	public void addPersonAlongWithAddress() {
		GenericDao dao = new GenericDao();
		Person p =new Person();
		p.setName("chaitanya");
		p.setDateOfBirth(LocalDate.of(1,1, 1));
		Address a = new Address() ;
		a.setFlat_no(1);
		a.setLandmark("opp ambernath");
		a.setCity("ambernath");
		a.setPincode(400097);
		a.setPerson(p);
		dao.upsert(a);
		
	}
}
