package ca.bytetube.ood._05_linkedin;

import java.util.*;

public class SocialSystem {
    AccountRegister accountRegister;
    PostRegister postRegister;

    NotificationRegister notificationRegister;

    public SocialSystem(AccountRegister accountRegister, PostRegister postRegister, NotificationRegister notificationRegister) {
        this.accountRegister = accountRegister;
        this.postRegister = postRegister;
        this.notificationRegister = notificationRegister;
    }

    public Account createUser(String name) {
        Account user = accountRegister.createAccount(name);
        notificationRegister.newAccount(user);
        return user;
    }

    public Post post(Account user, String content) {
        return postRegister.makePost(content, user);
    }

    public void comment(Post post, String content, Account addCommentUser) {
        postRegister.addComments(post, content, addCommentUser);
        Account postCreator = postRegister.findCreator(post);
        notificationRegister.hasBehaviorOnPost(postCreator, addCommentUser, post, "comment");
    }

    public void like(Post post, Account likeCommentUser) {
        postRegister.likes(post, likeCommentUser);
        Account postCreator = postRegister.findCreator(post);
        notificationRegister.hasBehaviorOnPost(postCreator, likeCommentUser, post, "like");
    }

    public void follow(Account followedAccount, Account followerAccount) {
        accountRegister.addRelationship(followedAccount, followerAccount, Status.FOLLOWED, Status.FOLLOWING);
        notificationRegister.hasBehaviorOnAccount(followedAccount, followerAccount, "followed");
    }

    public void connect(Account connectedAccount, Account connectorAccount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(connectorAccount.getUserName() + " want to connect with " + connectedAccount.getUserName() + ". Does he/she accept?");
        int input = scanner.nextInt();
        scanner.close();
        if (input == 0) {
            System.out.println(connectedAccount.getUserName() + " doesn't want to connect with " + connectorAccount.getUserName());
            return;
        }
        accountRegister.addRelationship(connectedAccount, connectorAccount, Status.CONNECTED, Status.CONNECTED);
        notificationRegister.hasBehaviorOnAccount(connectedAccount, connectorAccount, "connected");
        notificationRegister.hasBehaviorOnAccount(connectorAccount, connectedAccount, "connected");
    }

    public void send(Account sender, Account sended, Post post) {
        notificationRegister.hasBehaviorOnPost(sended, sender, post, "send");
    }

    public void getNotification(Account account) {
        notificationRegister.getNotification(account);
    }


}
