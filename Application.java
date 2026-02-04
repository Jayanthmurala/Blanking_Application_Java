package BankingApplication;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
 // Application class
public class Application{
	
	Application1 app1 = new Application1();
	App app = new App();
	public void menu() {
		System.out.println("Welcome to the ATM Machine");
		System.out.println("1. Generate Pin");
		System.out.println("2. Check Balance");
		System.out.println("3. Withdraw Cash");
		System.out.println("4. Deposit Cash");
		System.out.println("5. Display Transaction History");
		System.out.println("6. Create Account");
		System.out.println("7. Display Account Details");
		System.out.println("8. Exit");
		System.out.print("Please select an option: ");
	}

	// AppGateway
	void appGateway() {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			menu();
			switch (sc.nextInt()) {
				case 1:
					System.out.print("Enter new Pin: ");
					int newPin = sc.nextInt();
					app.setPin(newPin);
					break;
				case 2:
					System.out.print("Enter Pin to check balance: ");
					int enteredPin = sc.nextInt();
					if (enteredPin == app.getPin()) {
						app1.checkBalance();
					} else {
						System.out.println("Incorrect Pin.");
					}
					break;
				case 3:
					System.out.print("Enter Pin to withdraw cash: ");
					enteredPin = sc.nextInt();
					if (enteredPin == app.getPin()) {
						app1.withdraw();
					} else {
						System.out.println("Incorrect Pin.");
					}
					break;
				case 4:
					System.out.print("Enter amount to deposit: ");
					long amount = sc.nextLong();
					app1.deposit(amount);
					break;
				case 5:
					app1.displayTransactionHistory();
					break;
				case 6:
					app.createAccount();
					break;
				case 7:
					app.displayAccountDetails();
					break;
				case 8:
					exit = true;
					System.out.println("Exiting the ATM Machine. Thank you!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

// Implementation of Transportation abstract class
class Application1 extends Transportation{
	//
	HashMap<String, Long> transactionHistory = new HashMap<>();
	private long amount = 0;

	@Override
	public void deposit(long n) {
		amount += n;
		//Add to transaction history
		String timestamp = LocalDateTime.now().toString();
		transactionHistory.put(timestamp + "Deposit", n);
		System.out.println(" >>>>> Deposited amount: " + n);
	}

	@Override
	public void withdraw() {
		if (amount > 0) {
			System.out.println(" >>>> Withdrawing amount: " + amount);
			amount = 0;
			// Add to transaction history
			String timestamp = LocalDateTime.now().toString();
			transactionHistory.put(timestamp + "Withdeaw", amount);
		} else {
			System.out.println(" >>>>>> Insufficient balance to withdraw.");
		}
	}

	@Override
	public void checkBalance() {
		System.out.println(" >>>> Checking balance..." + getAmount());
	}

	@Override
	public void displayTransactionHistory() {
		System.out.println("Transaction History:");
		for (String timestamp : transactionHistory.keySet()) {
			System.out.println(" >>>> Time: " + timestamp + ", Amount: " + transactionHistory.get(timestamp));
		}
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}

// Implementation of AccountCreation abstract class
class App extends AccountCreation{
	//
	private int AccountNumber;
	@Override
	public void createAccount() {
		setAccountNumber((int)(Math.random() * 1000000));
		System.out.println(" >>> Account created successfully. Your account number is: " + getAccountNumber());
	}
	@Override
	public void displayAccountDetails() {
		System.out.println("Account Details:");
		System.out.println(">>>>Account Number: " + getAccountNumber());
	}
	public void setPin(int pin) {
		super.setPin(pin);
		System.out.println(">>>>Account pin set Successfully.");
	}

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}
	
}
