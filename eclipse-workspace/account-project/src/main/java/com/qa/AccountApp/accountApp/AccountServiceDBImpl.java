package com.qa.AccountApp.accountApp;

import java.util.Collection;

import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Transactional
public class AccountServiceDBImpl implements AccountRepo {
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	
	private JSONUtil util;
	
	
	
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> AccList = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(AccList);
	
	}
		
		@Transactional
	
	public String addAccount(String Account) {
//		JSONUtil util = new JSONUtil();
		Account acc1=util.getObjectForJSON (Account, Account.class);
		manager.persist(acc1);
		return "{\"message\":\"Account Added\"}";
	}
	
		@Transactional
		public String deleteAccount(Long id) {
			Account accountInDB = findMovie(id);
			if (accountInDB != null) {
				manager.remove(accountInDB);
			}
			return "{\"message\": \"movie sucessfully deleted\"}";
		}
		
		public String getAccount(Long id) {
			Account aMovie =  manager.find(Account.class, id);
			return util.getJSONForObject(aMovie);
		}

		private Account findMovie(Long id) {
			return manager.find(Account.class, id);
		}

		public void setManager(EntityManager manager) {
			this.manager = manager;
		}

		public void setUtil(JSONUtil util) {
			this.util = util;
		}



		

	}
