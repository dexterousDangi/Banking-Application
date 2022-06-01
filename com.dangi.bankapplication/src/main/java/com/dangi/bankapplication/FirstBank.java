package com.dangi.bankapplication;

public class FirstBank {

	public static void main(String[] args) {
		
		Account pardeep=new Account("Pardeep Dangi","A00001");
		pardeep.showMenu();
		
		Account dangi=new Account("Dangi","B00001");
		dangi.showMenu();
	}

}
