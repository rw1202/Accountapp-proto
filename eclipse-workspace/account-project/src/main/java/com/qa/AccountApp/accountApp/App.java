package com.qa.AccountApp.accountApp;

import java.util.HashMap;


public class App 
{
	
    public static void main( String[] args )
    {
    AccountSystem accountSystem = new AccountSystem();
    
    accountSystem.addAccount(0, "John", "Bishop", "19202711");
    accountSystem.addAccount(1, "Perry", "Bishop", "19122711");	
    
  	accountSystem.getAccount(1);
  	
  	
    	
    }
}
