package com.bank;

public class bank {
	int accountNumber = 123456789;
	double balance = 50.0;
	String customerName = "Lily";
	String email = "liyun4339@gmail.com";
	String PhoneNum = "9513845735";
	
	public void depositFunds(double addOn) {
		balance += addOn;
	}
	
	public void withDraw(double amount) {
		if(balance - amount <= 0) {
			System.out.println("balance is not enough, please redo it.");
		}	
		else
			balance -= amount;
		System.out.println("The balance of this account is: " + balance);
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNum() {
		return this.PhoneNum;
	}
	
	private void setAccountNumber(int name) {
		this.accountNumber = name;
	}
	
	public void setAccountName(String name) {
		this.customerName = name;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.PhoneNum = phoneNum;
	}
	
	public void getInfo() {
		System.out.println("Customer Name is: " + customerName);
		System.out.println("Account Number is: " + accountNumber);
		System.out.println("Balance is: " + balance);
		System.out.println("Email is: " + email);
		System.out.println("PhoneNumber is: " + PhoneNum);
	}
	
	
	
}
