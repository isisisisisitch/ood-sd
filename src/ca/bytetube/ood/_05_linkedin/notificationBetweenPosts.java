package ca.bytetube.ood._05_linkedin;

public class notificationBetweenPosts extends Notification{
    Post post;
    String action;

    public notificationBetweenPosts(Account account, Post post, String action) {
        super(account);
        this.post = post;
        this.action = action;
    }

    @Override
    public void getNotification() {
        System.out.println(account.getUserName() + " has " + action + " post: " + post.getPostId());
    }

}
