import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public double getBalance( ) {
        return balance;
    }
}
class ATM {
    private BankAccount bankAccount;
    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void userInterface( ) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM");
        while (true) {
            System.out.println("/nOptions:");
            System.out.println("1. Withdraw");
            System.out.println("2.Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 2:
                checkBalance();
                break;
            case 311:
                System.out.println("Thank you for using the ATM. Goodbye!");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void withdraw(double amount) {
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient balance. Transaction failed.");
        }
    }
    private void checkBalance( ) {
        double balance = bankAccount.getBalance();
        System.out.println("Your current balance is: $" + balance);
    }
}
public class Main {
    public static void main(String[ ] args) {
        BankAccount userAccount = new BankAccount(1000);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.userInterface();
    }
}