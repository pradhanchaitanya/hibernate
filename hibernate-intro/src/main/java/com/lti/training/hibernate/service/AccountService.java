package com.lti.training.hibernate.service;

import java.time.LocalDateTime;
import java.util.List;

import com.lti.training.hibernate.dao.AccountDao;
import com.lti.training.hibernate.entity.Account;
import com.lti.training.hibernate.entity.Transaction;

/*
 * Classes which contain Business Logic
 */
public class AccountService {
	
//	private static GenericDao dao = new GenericDao();
	
	public void openAccount(Account acc) {
		AccountDao dao = new AccountDao();
		dao.upsert(acc);
		System.out.println("account created...");	// send ack email and sms
	}
	
	public void withdraw(long ac,double amount) {
		AccountDao dao = new AccountDao();
		Account acc = (Account) dao.fetchById(Account.class, ac);
		if (amount < checkBalance(ac)) {
			Transaction tx = new Transaction();
			tx.setAmount(amount);
			tx.setType("Withdraw");
			tx.setDateAndTime(LocalDateTime.now());
			tx.setAccount(acc);
			dao.upsert(tx);
			acc.setBalance(acc.getBalance() - amount);
			dao.upsert(acc);
		} else {
			System.out.println("Insufficient funds");
		}
	}
	
	public void deposit(long acno,double amount) {
		AccountDao dao = new AccountDao();
		Account acc = (Account) dao.fetchById(Account.class, acno);
		Transaction tx = new Transaction();
		tx.setAmount(amount);
		tx.setType("Deposit");
		tx.setDateAndTime(LocalDateTime.now());
		tx.setAccount(acc);
		dao.upsert(tx);
		acc.setBalance(acc.getBalance() + amount);
		dao.upsert(acc);
	}
	
	public void transfer(long fromAcno,long toAcno,double amount) {
		AccountDao dao = new AccountDao();
		Account toAcc = (Account) dao.fetchById(Account.class, toAcno);
		Account fromAcc = (Account) dao.fetchById(Account.class, fromAcno);
		if (amount < checkBalance(fromAcno)) {
			Transaction withdraw = new Transaction();
			withdraw.setAmount(amount);
			withdraw.setType("Withdraw");
			withdraw.setDateAndTime(LocalDateTime.now());
			withdraw.setAccount(fromAcc);
			dao.upsert(withdraw);
			
			Transaction deposit = new Transaction();
			deposit.setAmount(amount);
			deposit.setType("Deposit");
			deposit.setDateAndTime(LocalDateTime.now());
			deposit.setAccount(toAcc);
			dao.upsert(deposit);
			
			toAcc.setBalance(toAcc.getBalance() + amount);
			fromAcc.setBalance(fromAcc.getBalance()-amount);
			dao.upsert(toAcc);
			dao.upsert(fromAcc);
		} else {
			System.out.println("Insufficient funds");
		}
		
	}
	
	public double checkBalance(long acno) {
		AccountDao dao = new AccountDao();
		Account acc = (Account) dao.fetchById(Account.class, acno);
		
		return acc.getBalance();
	}
	
	public List<Account> fetchAccountsByType(String type) {
		return new AccountDao().fetchAccountsByType(type);
	}
	public List<Account> fetchAccountsByBalance(double balance) {
		return new AccountDao().fetchAccountsByBalance(balance);
	}
	
	public List<Transaction>fetchStatement(long acno){
		return new AccountDao().fetchStatement(acno);
	}
}
