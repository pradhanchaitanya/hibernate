package com.lti.training.test;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import com.lti.training.hibernate.dao.CustomerDao;
import com.lti.training.hibernate.entity.Customer;

public class CustomerTest {
	
	@Test
	public void testAdd() {
		Customer C = new Customer();
		C.setName("Majrul");
		C.setEmail("m@lti");
		C.setCity("mumbai");
		
		CustomerDao dao = new CustomerDao();
		dao.add(C);
	}
	@Test
	public void testFetchById() {
		CustomerDao dao = new CustomerDao();
		Customer c =dao.fetchById(1);
		assertNotNull(c);
		System.out.println(c.getName());
		System.out.println(c.getEmail());
		System.out.println(c.getCity());
	}
	@Test
	public void testUpdate() {
		CustomerDao dao = new CustomerDao();
		Customer c = dao.fetchById(1);
		c.setEmail("m@gmail.com");
		dao.update(c);
		
	}
}
