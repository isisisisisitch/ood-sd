package ca.bytetube.ood._04_bank;

public class Withdrawal extends Transaction {
    private int amount;

    public Withdrawal(int customerId, int tellerId, int amount) {

        super(customerId, tellerId);
        this.amount = amount;
    }

    @Override
    public String getTransactionDes() {
        return "Teller " + getTellerId() + " withdrawal " + amount + getCustomerId();
    }
}
