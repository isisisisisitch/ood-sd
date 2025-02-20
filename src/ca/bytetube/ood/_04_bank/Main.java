package ca.bytetube.ood._04_bank;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BankSystem system = new BankSystem(new ArrayList<BankAccount>(), new ArrayList<Transaction>());
        Bank bank = new Bank(new ArrayList<BankBranch>(),system,1000);

        BankBranch branch1 = bank.addBranch("111 ave",100);
        BankBranch branch2 = bank.addBranch("222 ave",100);

        branch1.addTeller(new Teller(1));
        branch1.addTeller(new Teller(2));
        branch2.addTeller(new Teller(3));
        branch2.addTeller(new Teller(4));

        int accountId1 = branch1.openAccount("aaa");
        int accountId2 = branch1.openAccount("bbb");
        int accountId3 = branch2.openAccount("ccc");

        branch1.deposit(accountId1,5);
        branch1.deposit(accountId2,10);
        branch2.deposit(accountId3,15);

        bank.printTransactions();

    }
}
