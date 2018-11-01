package com.qa.AccountApp.accountApp;

import java.util.Collection;

import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional(SUPPORTS)
public class AccountServiceDBImpl {
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	
	private JSONUtil util;
	
	
	
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> AccList = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(AccList);
	
	}
		
		@Transactional(REQUIRED)
	
	public String createAccount(String Account) {
//		JSONUtil util = new JSONUtil();
		Account acc1=util.getObjectForJSON (Account, Account.class);
		manager.persist(acc1);
		return "{\"message\":\"Account Added\"}";
	}
	
	
	
}
