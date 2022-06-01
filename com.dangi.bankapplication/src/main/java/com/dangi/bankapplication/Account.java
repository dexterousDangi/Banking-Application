package com.dangi.bankapplication;

import java.util.Scanner;

public class Account {

	// class Variable
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;

	// Class constructor
	Account(String cname, String cid) {
		customerName = cname;
		customerID = cid;
	}

	// Method for Depostitng money
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	// Method for Withdrawing money
	void withdrawing(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}

	// Method showing the previous Transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Amount Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Amount Withdrawn:	" + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occurred");
		}
	}

	// Method to calculate the interest of the current fund after a number of years

	void calculateInterest(int years) {
		double interestRate = .076;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is :" + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}

	// Method to show all the funtionallity: or say Main menu display

	void showMenu() {
		char option = '\0';
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome " + customerName + " !");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate the interest");
		System.out.println("F. Exit");

		do {
			System.out.println();
			System.out.println("Enter a Option:");
			char option1 = scan.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();

			switch (option) {
			// case 'A' allows user to check their account balance
			case 'A':
				System.out.println("===============================");
				System.out.println("Balance = Rs." + balance);
				System.out.println("===============================");
				System.out.println();

				// case 'B' allows user to deposite into their account using respective method
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println();
				break;

			// case 'C' allows the user to withdraw money from their account using
			// withdrawing mehtod
			case 'C':
				System.out.println("Enter the amount you want to withdraw: ");
				int amount2 = scan.nextInt();
				withdrawing(amount2);
				System.out.println();
				break;

			// case 'D' allows the user to view their most recent transaction uisng
			// getPreviousTransaction() method
			case 'D':
				System.out.println("=============================");
				getPreviousTransaction();
				System.out.println("=============================");
				break;

			// case 'E' calculate the accured interest on the account after a number of
			// years eneterd years
			case 'E':
				System.out.println("Enter how many years of accured interest: ");
				int years = scan.nextInt();
				calculateInterest(years);
				break;

			// case 'F' exits the user from their account
			case 'F':
				System.out.println("=============================");
				break;

			// The default case let's the user know that they entered an invalid option
			default:
				System.out.println("Error: invalid opiton. Please enter A, B, C, D, E, F");

			}
		} while (option != 'F');
		System.out.println("thank you for banking with us!!!");
		System.out.println();
	
	}
}
