package com.qa.AccountApp.account;

import static org.junit.Assert.*;

import java.util.HashMap;


import org.junit.Test;

import com.qa.AccountApp.accountApp.Account;
import com.qa.AccountApp.accountApp.AccountSystem;

public class Tests {

	AccountSystem accountSystem = new AccountSystem();
	HashMap<Integer, Account> bankAccounts = new HashMap<Integer, Account>();

	@Test
	public void findFirstNamesTest() {

		int counter = 0;

		bankAccounts.put(0, new Account("John", "Bishop", "19202711"));
		bankAccounts.put(1, new Account("John", "Bishop", "19202711"));

		for (int i = 0; i <= bankAccounts.size() - 1; i++)
			if (bankAccounts.get(i).getFirstName() == "John") {
				counter++;
			}

		assertEquals(2, counter);
	}

	@Test
	public void findFirstNamesTestWithStreams() {

		int counter = 0;

		bankAccounts.put(0, new Account("John", "Bishop", "19202711"));
		bankAccounts.put(1, new Account("John", "Bishop", "19202711"));

		//bankAccounts.entrySet().stream().filter(x -> x.getValue().getFirstName().equals("John")).count();

		assertEquals(2, bankAccounts.entrySet().stream().filter(x -> x.getValue().getFirstName().equals("John")).count());
	}
}
