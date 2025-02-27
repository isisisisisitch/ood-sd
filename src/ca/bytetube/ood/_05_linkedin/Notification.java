package ca.bytetube.ood._05_linkedin;

public abstract class Notification {
    Account account;

    public Notification(Account account) {
        this.account = account;
    }

    public abstract void getNotification();

}
