package com.lily.project;

public class bankAcc {
	int accountId = 123456789;
	double balance = 50.0;
	String firstName = "Lily";
	String lastName = "Li";
	
	public bankAcc() {
		
	}
	public bankAcc(int accountId, double balance, String firstName, String lastName) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int depositFunds(double addOn) {
		balance += addOn;
		System.out.println("The balance of this account is: " + balance);
		return 1;
	}
	
	public int withDraw(double amount) {
		if(balance - amount <= 0) {
			System.out.println("balance is not enough, please redo it.");
			return 0;
		}	
		else
			balance -= amount;
		System.out.println("The balance of this account is: " + balance);
		return 1;
	}
	

}
