package ca.bytetube.ood._05_linkedin;

public class notificationBetweenAccounts extends Notification{
    String action;
    public notificationBetweenAccounts(Account account, String action) {
        super(account);
        this.action = action;
    }

    @Override
    public void getNotification() {
        System.out.println(account.getUserName() + " has " + action + " you");
    }
}
