package com.lti.training.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.lti.training.hibernate.dao.GenericDao;
import com.lti.training.hibernate.entity.Booking;
import com.lti.training.hibernate.entity.Passenger;
import com.lti.training.hibernate.entity.Passenger.Gender;

public class BookingPassengerTest {

	@Test
	public void addBookingAlongWithPassengers() {
		Booking booking = new Booking();
		booking.setAmount(10000);
		booking.setDate(LocalDate.now());
		
		Set<Passenger> passengers = new HashSet<Passenger>();
		
		Passenger passenger = new Passenger();
		passenger.setName("Chaitanya");
		passenger.setGender(Gender.MALE);
		passenger.setBooking(booking);
		passengers.add(passenger);
		
		passenger = new Passenger();
		passenger.setName("Parth");
		passenger.setGender(Gender.MALE);
		passenger.setBooking(booking);
		passengers.add(passenger);
		
		passenger = new Passenger();
		passenger.setName("Elton");
		passenger.setGender(Gender.MALE);
		passenger.setBooking(booking);
		passengers.add(passenger);
		
		booking.setPassengers(passengers);
		
		GenericDao dao = new GenericDao();
		dao.upsert(booking);
	}
	
	@Test
	public void fetchBooking() {
		GenericDao dao = new GenericDao();
		Booking booking = (Booking) dao.fetchById(Booking.class, 381);
		System.out.println(booking.getAmount());
		System.out.println(booking.getDate());
		for (Passenger p: booking.getPassengers()) {
			System.out.println(p.getName());
			System.out.println(p.getGender());
		}
	}
	
	@Test
	public void fetchPassenger() {
		GenericDao dao = new GenericDao();
		Passenger passenger = (Passenger) dao.fetchById(Passenger.class, 383);
		System.out.println(passenger.getName());
		System.out.println(passenger.getGender());
		System.out.println(passenger.getBooking());
	}
}
