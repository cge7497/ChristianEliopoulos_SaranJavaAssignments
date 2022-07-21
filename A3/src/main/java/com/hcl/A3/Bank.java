package com.hcl.A3;

public class Bank {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.deposit(500, 100);
		bank.withdraw(500, 1000);
		bank.withdraw(500, 200);
	}
	
	double  deposit(double amt, double balance) {
		double newBalance = balance + amt;
		
		if (newBalance <= 0) newBalance = 0;
		
		System.out.println(String.format("Deposited %.2f into balance of %.2f. New balance is %.2f", amt, balance, newBalance));
		
		return newBalance;
	}
	
	double withdraw(double amt, double balance) {
		double newBalance = balance - amt;
		
		if (newBalance <= 0) newBalance = 0;
		
		System.out.println(String.format("Withdrew %.2f from balance of %.2f. New balance is %.2f", amt, balance, newBalance));
		
		return newBalance;
	}
/*
 * ii)Create a Bank class with methods deposit & withdraw. The deposit method would accept attributes amount & balance 
 * ( returns the new balance which
is the sum of amount & balance. Similarly the withdraw method would accept the attributes amount & balance & 
returns the new balance
if(balance >=amount or return 0 otherwise
 */
	
}
