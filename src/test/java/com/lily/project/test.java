package com.lily.project;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		bankAcc b1 = new bankAcc();
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please choose options: 1 for Account Balance, 2 for DepositFunds, 3 for Money Withdrawn and else for exit.");
		
	    int typeIn = myObj.nextInt();
		while(true) {
			if(typeIn != 1 && typeIn !=2 && typeIn != 3) {
				System.out.println("Exiting...");
				return;
			}
	    	if(typeIn == 1)
	    		System.out.println("balance is: " + b1.getBalance());
	    	else if(typeIn == 2) {
	    		System.out.println("Please type in the amount to be deposit");
	    		double amount = myObj.nextDouble();
	    		b1.depositFunds(amount);
	    		System.out.println("Now your balance is: " + b1.getBalance());
	    	}
	    	else if(typeIn == 3) {
	    		System.out.println("Please type in the amount to be withdrawn");
	    		double amount = myObj.nextDouble();
	    		b1.withDraw(amount);
	    		System.out.println("Now your balance is: " + b1.getBalance());
	    	}
			System.out.println("Please choose options: 1 for Account Balance, 2 for DepositFunds, 3 for Money Withdrawn and else for exit.");
			typeIn = myObj.nextInt();
		}
	}
}
