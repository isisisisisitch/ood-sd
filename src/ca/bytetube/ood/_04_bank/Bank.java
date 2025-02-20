package ca.bytetube.ood._04_bank;

import java.util.List;

public class Bank {
    private List<BankBranch> branches;
    private BankSystem system;
    private int totalCash;

    public Bank(List<BankBranch> branches, BankSystem system, int totalCash) {
        this.branches = branches;
        this.system = system;
        this.totalCash = totalCash;
    }

    public BankBranch addBranch(String address, int initFunds) {
        BankBranch branch = new BankBranch(address, system, initFunds);
        branches.add(branch);
        return branch;
    }

    public void collectCash(double ratio) {
        for (BankBranch branch : branches) {
            int cashCollected = branch.collectCash(ratio);
            totalCash += cashCollected;
        }

    }


    public void printTransactions() {
        for (Transaction transaction : system.getTransactions()) {
            System.out.println(transaction.getTransactionDes());
        }
    }


}
