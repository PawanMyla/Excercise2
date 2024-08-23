import java.util.Scanner;

abstract class Account {
    protected int accountNumber;
    protected String name;
    protected double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Account Balance: " + balance);
    }
}

final class SavingsAccount extends Account {
    private final static double INTEREST_RATE = 0.04 / 12; // Monthly interest rate
    private final static double MINIMUM_BALANCE = 500.0;

    public SavingsAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least " + MINIMUM_BALANCE);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MINIMUM_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

final class CurrentAccount extends Account {
    private final static double MINIMUM_BALANCE = 1000.0;

    public CurrentAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
        if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException("Initial balance must be at least " + MINIMUM_BALANCE);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MINIMUM_BALANCE) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}


public class BankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account type (SB/CA): ");
        String accountType = scanner.nextLine();

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Account account = null;
        try {
            if (accountType.equalsIgnoreCase("SB")) {
                account = new SavingsAccount(accountNumber, name, balance);
            } else if (accountType.equalsIgnoreCase("CA")) {
                account = new CurrentAccount(accountNumber, name, balance);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        if (account != null) {
            account.displayAccountDetails();

            // Logic for deposits and withdrawals
            while (true) {
                System.out.println("\nWhat would you like to do?");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Display Account Details");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                
                if (choice == 1) {
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("New Balance: " + account.balance);
                } else if (choice == 2) {
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    System.out.println("New Balance: " + account.balance);
                } else if (choice == 3) {
                    account.displayAccountDetails();
                } else if (choice == 4) {
                    System.out.println("Thank you for using our service.");
                    break;
                } else {
                    System.out.println("Invalid choice! Please select a valid option.");
                }
            }
        }

        scanner.close();
    }
}
