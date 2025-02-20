package ca.bytetube.ood._04_bank;

public class OpenAccount extends Transaction {

    public OpenAccount(int customerId, int tellerId) {
        super(customerId, tellerId);
    }

    @Override
    public String getTransactionDes() {
        return "Teller " + getTellerId() + " open account " + getCustomerId();
    }
}
