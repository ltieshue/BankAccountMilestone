package edu.gcu.bootcamp.java.Lori.tieshue.bankaccountmilestone;


/*The Saving class extends the Account class which means it inherits everything from Account (i.e. variables, methods etc.).
 * If there is a method that needs to function differently for the Saving class than what was defined in the Account class it can be 
 * defined in the Saving class. If that is the case then the method in the Saving class will be used and not the method in the Account class.
 */ 



public class Savings extends Account {
	private double serviceFee = 25.00;
	private double annualInterestRate = .06;
	private double minBalance = 200.00;
	
	
	


	
	public Savings (double balance, String accountID ) {
		this.setBalance(balance);
		this.setAccountID(accountID);
	}
	

	public double getServiceFee() {
		return serviceFee;
	}



	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}



	public double getAnnualInterestRate() {
		return annualInterestRate;
	}



	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}



	public double getMinBalance() {
		return minBalance;
	}



	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}
	

	
	
	
}