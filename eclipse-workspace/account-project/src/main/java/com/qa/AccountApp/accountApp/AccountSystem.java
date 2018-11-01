package com.qa.AccountApp.accountApp;

import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.simple.JSONObject;



public class AccountSystem {
	
	
//	HashMap<Integer, Account> bankAccounts = new HashMap<Integer, Account>();
//	static int counter = 0;
//	


	
	public void addAccount(int counter, String firstName, String secondName, String accountNumber) {
		
		bankAccounts.put(counter, new Account(firstName, secondName, accountNumber));
		counter++;
	}
	
	public void getAccount(int id) 
	{
		JSONObject obj = new JSONObject();
		
		obj.put(id,(bankAccounts.get(id).getFirstName() + " " + bankAccounts.get(id).getLastName() + " " + bankAccounts.get(id).getAccountNumber()));
		
		;
		System.out.println(obj);
		
	}
	
	
	
	
	
	
	
	
}
