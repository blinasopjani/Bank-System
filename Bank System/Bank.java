import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String name, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        this.name = name;
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void performTransaction(double amount, int fromAccountId, int toAccountId, String reason) {
        Account fromAccount = getAccountById(fromAccountId);
        Account toAccount = getAccountById(toAccountId);

        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Account not found");
        }

        double fee = calculateFee(amount);
        double totalAmount = amount + fee;

        if (fromAccount.getBalance() < totalAmount) {
            throw new IllegalArgumentException("Not enough funds");
        }

        fromAccount.withdraw(totalAmount);
        toAccount.deposit(amount);

        totalTransactionFeeAmount += fee;
        totalTransferAmount += amount;

        Transaction transaction = new Transaction(amount, fromAccountId, toAccountId, reason);
        System.out.println("Transaction performed: " + transaction);
    }

    public double checkAccountBalance(int accountId) {
        Account account = getAccountById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found");
        }
        return account.getBalance();
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    private Account getAccountById(int accountId) {
        for (Account account : accounts) {
            if (account.getId() == accountId) {
                return account;
            }
        }
        return null;
    }

    private double calculateFee(double amount) {
        return transactionFlatFeeAmount + (amount * transactionPercentFeeValue / 100);
    }
}
