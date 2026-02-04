package BankingApplication;

public abstract class AccountCreation implements AccountCreationInterface {
	private int pin = 0000;
	
//	 public abstract void createAccount();
	 public void closeAccount() {
		 System.out.println(" >>>>> Account closed successfully.");
	 }
//	 public abstract void displayAccountDetails();
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void createAccount() {
		// TODO Auto-generated method stub
		
	}

}
