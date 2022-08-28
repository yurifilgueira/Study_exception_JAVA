package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int numberAccount = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holderName = sc.nextLine();
		System.out.print("Initial balance: ");
		double initialBalance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(numberAccount, holderName, initialBalance, withdrawLimit);
		
		System.out.print("Enter amount for withdraw: ");
		double withdrawValue = sc.nextDouble();
		try {
		    acc.withdraw(withdrawValue);
		    System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();

	}

}
