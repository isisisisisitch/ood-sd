package ca.bytetube.ood._04_bank;

public class Deposit extends Transaction {
    private int amount;

    public Deposit(int customerId, int tellerId, int amount) {
        super(customerId, tellerId);
        this.amount = amount;
    }

    @Override
    public String getTransactionDes() {
        return "Teller "+ getTellerId() + " deposited " + amount + " to account " +getCustomerId() ;
    }
}
