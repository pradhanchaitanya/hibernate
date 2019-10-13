package com.lti.training.test;

import java.util.List;

import org.junit.Test;

import com.lti.training.hibernate.entity.Account;
import com.lti.training.hibernate.entity.Transaction;
import com.lti.training.hibernate.service.AccountService;

public class AccountTxnTest {

	@Test
	public void addAccount() {
		Account acc = new Account();
//		acc.setAccountNo(123456789);
		acc.setBalance(10000);
		acc.setName("Chaitanya");
		acc.setType("Savings");
		acc.setTransactions(null);
		
		AccountService serve = new AccountService();
		serve.openAccount(acc);
	}
	
	@Test
	public void checkBalance() {
		AccountService serve = new AccountService();
		System.out.println(serve.checkBalance(221));
	}
	
	@Test
	public void withdraw() {
		AccountService serve = new AccountService();
		serve.withdraw(221, 300);
	}
	
	@Test
	public void deposit() {
		AccountService serve = new AccountService();
		serve.deposit(241, 700);
	}
	
	@Test
	public void transfer() {
		AccountService serve = new AccountService();
		serve.transfer(221, 241, 3500);
	}
	
	@Test
	public void fetchAccountsByType() {
		AccountService serve = new AccountService();
		List<Account> accounts = serve.fetchAccountsByType("Savings");
		for (Account a: accounts) {
			System.out.println(a.getAccountNo());
			System.out.println(a.getName());
			System.out.println(a.getBalance());
			System.out.println("---------------");
		}
	}
	
	@Test
	public void fetchAccountsByBalance() {
		AccountService serve = new AccountService();
		List<Account> accounts = serve.fetchAccountsByBalance(5000);
		for (Account a: accounts) {
			System.out.println(a.getAccountNo());
			System.out.println(a.getName());
			System.out.println(a.getBalance());
			System.out.println("---------------");
		}
	}
	
	@Test
	public void fetchStatement() {
		AccountService serve = new AccountService();
		List<Transaction> transactions = serve.fetchStatement(241);
		for (Transaction tx: transactions) {
			System.out.println("Txn No: " + tx.getTxnNo());
			System.out.println("Amount: " + tx.getAmount());
			System.out.println("Type: " + tx.getType());
			System.out.println("---------------");
		}
	}
}