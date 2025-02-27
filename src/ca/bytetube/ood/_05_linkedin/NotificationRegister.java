package ca.bytetube.ood._05_linkedin;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class NotificationRegister {
    Map<Account, List<Notification>> notifications = new HashMap<>();

    public void newAccount(Account user) {
        List<Notification> tmp = new LinkedList<>();
        notifications.put(user, tmp);
    }

    public void hasBehaviorOnPost(Account postCreator, Account behaviorUser, Post post, String behavior) {
        List<Notification> creatorNotification = notifications.get(postCreator);
        creatorNotification.add(new notificationBetweenPosts(behaviorUser, post, behavior));
        notifications.put(postCreator, creatorNotification);
    }

    public void hasBehaviorOnAccount(Account beLinkedAccount, Account toLinkedAccount, String behavior) {
        List<Notification> beLinkedNotification = notifications.get(beLinkedAccount);
        beLinkedNotification.add(new notificationBetweenAccounts(toLinkedAccount, behavior));
        notifications.put(beLinkedAccount, beLinkedNotification);
    }

    public void getNotification(Account account) {
        System.out.println("Following are notifications received by: " + account.getUserName());
        List<Notification> lists = notifications.get(account);
        for (Notification each : lists) each.getNotification();
    }
}
