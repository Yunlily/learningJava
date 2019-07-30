package com.lily.flexon;

import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
		
		
		System.out.println("Hello Team!!");
		
		int a = 500;
		short b = 10;
		byte c = 30;
		long d = 70000 + 15 * a + b + c;
		System.out.println("The result is: " + d);
		
		double pound = 100;
		double kilos = pound *  0.45359237;
		System.out.println("The result is: " + kilos + "kg.");
		
		int value = 1;
		
		if(value == 1)
			System.out.println("Value is equal to 1");
		
		if(value == 1)
			System.out.println("Value is equal to 1");
		else
			System.out.println("Value is not equal to 1");
		
		if(value == 1)
			System.out.println("Value is equal to 1");
		else if(value == 2)
			System.out.println("Value is equal to 2");
		else if(value == 3)
			System.out.println("Value is equal to 3");
		else
			System.out.println("Value is not equal to 1, 2 or 3");
		
		
		double var1 = 20;
		double var2 = 80;
		double var3 = (var1 + var2) * 25;
		System.out.println("#3 is: " + var3);
		double remainder = var3 % 40;
		if(remainder <= 20)
			System.out.println("Total was over the limit");
		
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter a character: ");
	    char ch = scanner.next().charAt(0);
	    String output;
	    
	    switch (ch) { 
        case 'A': 
            output = "Apple"; 
            break; 
        case 'B': 
        	output = "Banana"; 
            break; 
        case 'C': 
        	output = "Cherries"; 
            break; 
        case 'D': 
        	output = "D"; 
            break; 
        case 'E': 
        	output = "E"; 
            break; 
        default: 
        	output = "N/A"; 
            break; 
        } 
        System.out.println("The output is: " + output); 
		
	}
}
