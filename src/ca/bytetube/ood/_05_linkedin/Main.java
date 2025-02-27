package ca.bytetube.ood._05_linkedin;


public class Main {
    public static void main(String[] args) {
        AccountRegister accountRegister = new AccountRegister();
        PostRegister postRegister = new PostRegister();
        NotificationRegister notificationRegister = new NotificationRegister();

        SocialSystem linkedIn= new SocialSystem(accountRegister, postRegister, notificationRegister);
        Account alice = linkedIn.createUser("Alice");
        Account bob = linkedIn.createUser("Bob");
        Account claire = linkedIn.createUser("Claire");

        linkedIn.follow(alice, bob);
        linkedIn.connect(alice, claire);
        Post postAlice = linkedIn.post(alice, "today is a nice day!");
        Post postBob = linkedIn.post(bob, "cold!");
        linkedIn.like(postAlice, claire);
        linkedIn.comment(postBob, "agree", claire);
        linkedIn.send(alice, claire, postBob);

        linkedIn.getNotification(alice);
        linkedIn.getNotification(bob);
        linkedIn.getNotification(claire);
    }
}
