package ca.bytetube.ood._04_bank;

import java.util.List;

public class BankSystem {
    private List<BankAccount> accounts;
    private List<Transaction> transactions;

    public BankSystem(List<BankAccount> accounts, List<Transaction> transactions) {
        this.accounts = accounts;
        this.transactions = transactions;
    }

    public int openAccount(String customerName, int tellerId) {
        int accountId = accounts.size();
        BankAccount account = new BankAccount(accountId, customerName, 0);
        accounts.add(account);

        Transaction transaction = new OpenAccount(accountId, tellerId);
        transactions.add(transaction);

        return accountId;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public BankAccount getAccount(int accountId) {
        if (accountId < 0 || accountId >= accounts.size()) throw new RuntimeException("invalid accountId");
        return accounts.get(accountId);

    }

    public void deposit(int customerId, int tellerId, int amount) {
        BankAccount account = getAccount(customerId);
        account.deposit(amount);

        Transaction transaction = new Deposit(customerId, tellerId, amount);
        transactions.add(transaction);
    }

    public void withdraw(int customerId, int tellerId, int amount) {
        BankAccount account = getAccount(customerId);
        if (amount > account.getBalance()) throw new RuntimeException("insufficient cash in your account");
        account.withdraw(amount);

        Transaction transaction = new Deposit(customerId, tellerId, amount);
        transactions.add(transaction);
    }
}
