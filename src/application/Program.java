package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter account data: ");
            System.out.print("Number: ");
            int number = sc.nextInt();

            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();

            System.out.println("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println("Would you like to add money or withdraw money? [a/w] ");
            char t = sc.next().charAt(0);
            double amount = 0;

            if (t == 'a') {
                System.out.println("How many dollars do you want to add? ");
                amount = sc.nextDouble();
                account.deposit(amount);
            } else {
                System.out.println("How many dollars do you want to withdraw? ");
                amount = sc.nextDouble();
                account.withdraw(amount);
            }

            System.out.println("New balance: " + account.getBalance());
        }
        catch (DomainException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error.");
        }
        sc.close();
    }
}
