package edu.gcu.bootcamp.java.Lori.tieshue.bankaccountmilestone;

import java.util.Scanner;

//Because all of the classes are in the package we do not need to import any of the classes to the Bank class.
// The 'main' method needs to be in this class as it is required to call the methods. 

/* Because all of the classes are in the package we do not need to import any of the classes to the Bank class.
 * The 'main' method needs to be in this class as it is required to call the methods. 
 */


/* Because all of the classes are in the package we do not need to import any of the classes to the Bank class.
 * The 'main' method needs to be in this class as it is required to call the methods. 
 */


/***
 * Bank is the primary class in which the other classes and methods will be organized/outline of the sequence of events/methods.
 * @author Lori
 * @version 1.0
 */

public class Bank {

	Scanner sc = new Scanner(System.in);	
	private String name = "GCU Credit Union";
	
	/***
	 * main method needs to exist as it is the method that establishes the other events to be executed in this project.  
	 * In the main class the Bank, Savings and Checking classes are made into objects. 
	 * @param args
	 */
	
		public static void main (String[]args) {
			Bank bank = new Bank();
			Savings savings = new Savings(5000.0, "191923");
			Checking checking = new Checking(5000.0, "991773");
		
			
			bank.displayMenu(checking, savings);

			
			
		}
	
		
		/*** 
		 * The displayMenu method establishes the primary view for the end users.  Checking and Savings are the classes/objects that will be accessed/maintained.
		 * @param checking
		 * @param savings
		 */
		
		private void displayMenu(Checking checking, Savings savings) {
			int option;
			do {
				System.out.println("===================================");
				System.out.println("             MAIN MENU");
				System.out.println("            "+ this.name.toUpperCase());
				System.out.println("===================================");
				System.out.println("Pick an option: ");
				System.out.println("---------------------");
				System.out.println(" 1: : Deposit to Checking");
				System.out.println(" 2: : Deposit to Savings");
				System.out.println(" 3: : Write a Check");
				System.out.println(" 4: : Withdraw from Savings");
				System.out.println(" 5: : Get balance");
				System.out.println(" 6: : Close month");
				System.out.println("---------------------");
				System.out.println(" 9: : Exit");
				option= sc.nextInt();
				this.actionMenu(option,checking, savings);
			}
		while (option !=9);
				
		}
		

			
		private void actionMenu(int opt, Checking checking, Savings savings) {
			switch (opt) {
					
			case 1: displayDepositChecking(checking);
			break;
			
			case 2: displayDepositSavings(savings);
			break;
			
			case 3: displayWithdrawChecking(checking);
			break;
			
			case 4: displayWithdrawSavings(savings);
			break;
			
			case 5: displayBalanceScreen(checking, savings);
			break;
			
			case 6: doEndMonth(checking, savings);
			break;
			
			case 9: displayExitScreen();
			break;
			
			
			
			}
			
		}
	
		
		private void doEndMonth(Checking checking, Savings savings) {
			if (savings.getBalance() > savings.getMinBalance()) {
			savings.setBalance(savings.getBalance()*savings.getAnnualInterestRate()/12 + savings.getBalance()); 
			System.out.println("Savings Account balance: $" + savings.getBalance() + " at end of the month.");
			}
			else {
				savings.setBalance(savings.getBalance() - savings.getServiceFee());
			System.out.println("Savings Account balance: $" + savings.getBalance() + " at end of the month.");
			}
			System.out.println("Checking Account balance: $" + checking.getBalance() + " at end of the month.");
			}
			
		
	
					
		private void displayBalanceScreen(Checking checking, Savings savings) {
			System.out.println("Checking Account balance: $" + checking.getBalance());
			System.out.println("Savings Account balance: $" + savings.getBalance());
		}

		
		/*
		 * 
		 */
		private void displayDepositChecking(Checking checking) {
		
			System.out.println("DEPOSIT INTO Checking " + checking.getAccountID());
			System.out.println("Your Checking Account balance is: $" + checking.getBalance());
			Scanner sc = new Scanner(System.in);
			System.out.println("How much do you want to deposit: " );
			double amount = sc.nextDouble();
			checking.doDeposit(amount);
					
		}
			
		
		private void displayDepositSavings(Savings savings) {
			System.out.println("DEPOSIT INTO Savings " + savings.getAccountID() + ".");
			System.out.println("Your Savings Account balance is: $" + savings.getBalance() + ".");
			Scanner sc = new Scanner(System.in);
			System.out.println("How much do you want to deposit: " );
			double amount = sc.nextDouble();
			savings.doDeposit(amount);
			
		}
	
		
		private void displayWithdrawChecking(Checking checking) {
			System.out.println("WITHDRAW FROM Checking " + checking.getAccountID() + ".");
			System.out.println("Your Checking Account balance is: $" + checking.getBalance());
			System.out.println("You will have a $" + checking.getOverDraft() + " overdraft fee if check amount/withdraw exceeds balance.");
			Scanner sc = new Scanner(System.in);
			System.out.println("How much do you want to withdraw: " );
			double amount = sc.nextDouble();
		if (amount > checking.getBalance()) {
			System.out.println("OVERDRAFT NOTICE: $" + checking.getOverDraft() + " fee assessed!");
		}
		else {
			System.out.println("Your new balance is: $" + checking.getBalance() + ".");	
			}
			checking.doWithdraw(amount);
		}
		
		private void displayWithdrawSavings(Savings savings) {
			System.out.println("WITHDRAW FROM Savings " + savings.getAccountID() + ".");
			System.out.println("Your Savings Account balance is: $" + savings.getBalance());
			System.out.println("You will have a $" + savings.getServiceFee() + " service fee if balance is below $" + savings.getMinBalance() + " at the end of the month.");
			Scanner sc = new Scanner(System.in);
			System.out.println("How much do you want to withdraw: " );
			double amount = sc.nextDouble();
			savings.doWithdraw(amount);
		}
	
		

		private void displayExitScreen() {
				
				System.out.println("Thank you for being a GCU Credit Union loyal customer.");
				
			}
			
		
		
		
}	



