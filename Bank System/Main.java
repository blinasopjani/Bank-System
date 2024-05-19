import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank System!");
        System.out.print("Enter transaction flat fee amount: ");
        double flatFee = scanner.nextDouble();
        System.out.print("Enter transaction percent fee value: ");
        double percentFee = scanner.nextDouble();

        Bank bank = new Bank("My Bank", flatFee, percentFee);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create Account");
            System.out.println("2. Perform Transaction");
            System.out.println("3. Check Account Balance");
            System.out.println("4. List All Accounts");
            System.out.println("5. Check Total Transaction Fee Amount");
            System.out.println("6. Check Total Transfer Amount");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner, bank);
                    break;
                case 2:
                    performTransaction(scanner, bank);
                    break;
                case 3:
                    checkAccountBalance(scanner, bank);
                    break;
                case 4:
                    listAllAccounts(bank);
                    break;
                case 5:
                    System.out.println("Total transaction fee amount: $" + bank.getTotalTransactionFeeAmount());
                    break;
                case 6:
                    System.out.println("Total transfer amount: $" + bank.getTotalTransferAmount());
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Bank System!");
        scanner.close();
    }

    private static void createAccount(Scanner scanner, Bank bank) {
        System.out.print("Enter account ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        Account account = new Account(id, name, balance);
        bank.addAccount(account);
        System.out.println("Account created successfully.");
    }

    private static void performTransaction(Scanner scanner, Bank bank) {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter originating account ID: ");
        int fromAccountId = scanner.nextInt();
        System.out.print("Enter resulting account ID: ");
        int toAccountId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter transaction reason: ");
        String reason = scanner.nextLine();

        try {
            bank.performTransaction(amount, fromAccountId, toAccountId, reason);
            System.out.println("Transaction completed successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }

    private static void checkAccountBalance(Scanner scanner, Bank bank) {
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();

        try {
            double balance = bank.checkAccountBalance(accountId);
            System.out.println("Account balance: $" + balance);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listAllAccounts(Bank bank) {
        System.out.println("All accounts:");
        for (Account account : bank.getAllAccounts()) {
            System.out.println(account);
        }
    }
}
