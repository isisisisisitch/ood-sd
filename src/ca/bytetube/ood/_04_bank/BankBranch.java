package ca.bytetube.ood._04_bank;

import java.util.ArrayList;
import java.util.List;

public class BankBranch {
    private String address;
    private List<Teller> tellers;
    private BankSystem system;
    private int cashOnHand;

    public BankBranch(String address, BankSystem system, int cashOnHand) {
        this.address = address;
        this.system = system;
        this.cashOnHand = cashOnHand;
        tellers = new ArrayList<>();
    }

    public void addTeller(Teller teller) {
        tellers.add(teller);
    }

    public Teller getAvilableTeller() {
        int index = (int) (Math.random() * (tellers.size() - 1));
        return tellers.get(index);
    }

    public int openAccount(String customerName) {
        if (tellers.isEmpty()) throw new RuntimeException("there is no teller available");
        Teller teller = getAvilableTeller();
        return system.openAccount(customerName, teller.getId());
    }

    public void deposit(int customerId, int amount) {
        if (tellers.isEmpty()) throw new RuntimeException("there is no teller available");

        Teller teller = getAvilableTeller();

        system.deposit(customerId, teller.getId(), amount);
    }

    public void withdraw(int customerId, int amount) {
        if (amount > cashOnHand) throw new RuntimeException("branch does not have enough cash");
        if (tellers.isEmpty()) throw new RuntimeException("there is no teller available");
        Teller teller = getAvilableTeller();
        system.withdraw(customerId, teller.getId(), amount);

        cashOnHand -= amount;

    }

    public int collectCash(double ratio) {
        int cashToCollect = (int) Math.round(cashOnHand * ratio);
        cashOnHand -= cashToCollect;
        return cashToCollect;
    }


}
