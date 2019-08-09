package com.lily.project;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.InputMismatchException;
import java.util.Scanner;

public class bankApp {
	public static int dfBalance = 50;
	public static DockerContainer dc = new DockerContainer();
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to Online Bank Application System!");
		dc.createAccountTable();
		
		dc.createHistoryTable();
		System.out.println("Are you a new user?(0/1).");
		int aId = createNewUser();
		
		System.out.println("--------------------------------------------");
		
		optionService(aId);
		
		
	}
	

	public static int createNewUser() {
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		int aId = 0;
		try {
		while(true) {
			if(choice == 1) {
					System.out.println("Now creating new account....");
					System.out.println("Please input your firstName:");
					String firstName = scan.next();
					System.out.println("Please input your lastName:");
					String lastName = scan.next();
					String res = dc.addAccount(firstName, lastName, dfBalance);
					System.out.println("Your AccountId is " + res + ". Please remember it");
					aId = Integer.parseInt(res);
					dc.addHistory("Created", "SUCCEED", 0, dfBalance, aId);
					break;
				}
			else if(choice == 0) {
				System.out.println("Please input your accountId:");
				int accId = scan.nextInt();
				String res = dc.fetchName(accId);
				System.out.println("Hello!" + res + ", welcome to your bank account!");
				aId = accId;
				break;
				}
			}
		}catch(InputMismatchException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return aId;
	}
	
	public static void optionService(int acId) {
		double balance = dc.fetchBalance(acId);
		System.out.println("balance: " + balance);
		String fullName = dc.fetchName(acId);
		System.out.println("fullName: " + fullName);
		String[] arrOfStr = fullName.split(" ");
		String firstName = arrOfStr[0];
		String lastName = arrOfStr[1];
		bankAcc currUser = new bankAcc(acId,balance,firstName,lastName);
		Scanner scan = new Scanner(System.in);
		while(true) {
			popNotify();
			int choice = scan.nextInt();
			if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println("exiting...");
				break;
			}
			switch(choice) {
				case 1:
					System.out.println("Your Balance is: " + currUser.getBalance());
					break;
				case 2:
					System.out.println("Please input the amount you want to deposit.");
					double depo = scan.nextDouble();
					int succ = currUser.depositFunds(depo);
					if(succ == 1)
						dc.addHistory("Deposit","SUCCEED", depo, currUser.getBalance(), currUser.getAccountId());
					else
						dc.addHistory("Deposit", "FAILED", depo, currUser.getBalance(), currUser.getAccountId());
					break;
				case 3:
					System.out.println("Please input the amount you want to withdraw.");
					double with = scan.nextDouble();
					int suc = currUser.withDraw(with);
					if(suc == 1)
						dc.addHistory("Withdraw", "SUCCEED", with, currUser.getBalance(), currUser.getAccountId());
					else
						dc.addHistory("Withdraw", "FAILED", with, currUser.getBalance(), currUser.getAccountId());
					break;
				case 4:
					System.out.println("Are you for sure to delete this account?(0/1)");
					if(scan.nextInt() == 1) {
						dc.deleteAccount(acId);
						System.out.println("Thanks for using our service, we will miss you...");
						return;
					}
					break;
				case 5:
					break;
				default:
					break;
			}
		}
		dc.setAccount(currUser.getAccountId(), currUser.getFirstName(), currUser.getLastName(), currUser.getBalance());
	}
	
	public static void popNotify() {
		System.out.println("Please select following choices: ");
		System.out.println("1. Get Balance.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw.");
		System.out.println("4. Delete this account.");
		System.out.println("5. Track Account History.");
		System.out.println("type in anything else to exit.");
	}
}
