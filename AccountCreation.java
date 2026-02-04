package BankingApplication;

public abstract class AccountCreation {
	private int pin = 0000;
	
	 public abstract void createAccount();
	 public void closeAccount() {
		 System.out.println(" >>>>> Account closed successfully.");
	 }
	 public abstract void displayAccountDetails();
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

}
